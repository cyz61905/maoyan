package com.cyz.maoyan.controller;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.kernel.Config;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/9 下午4:32
 * @Version V1.0
 */

@RestController
@RequestMapping("alipay")
public class AlipayController {
    @Autowired
    private Config config;
    @Autowired
    private OrderService orderService;

    @GetMapping("pay")
    public String pay(@RequestParam("orderNo") String orderId, String amount) throws Exception {
        Factory.setOptions(config);
        AlipayTradePagePayResponse response = Factory.Payment.Page().pay("测试商品", orderId, amount, "http://127.0.0.1:5500/order.html");
        return response.getBody();
    }

    @PostMapping("notify")
    public AjaxResult notify(HttpServletRequest request){
        try {
            Map<String, String[]> map = request.getParameterMap();
            Map<String, String> param = new HashMap<>();
            for (Map.Entry<String, String[]> entry : map.entrySet()) {
                StringBuilder value = new StringBuilder();
                for (String s : entry.getValue()) {
                    value.append(s);
                }
                param.put(entry.getKey(), value.toString());
            }
            Factory.setOptions(config);
            Boolean verifyNotify = Factory.Payment.Common().verifyNotify(param);
            if(!verifyNotify){
                System.out.println("支付成功 request = " + request);
                orderService.payOrder(request.getParameter("out_trade_no"));
                return AjaxResult.success().msg("支付成功");
            }else {
                return AjaxResult.error("支付异常");
            }
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("支付异常");
        }
    }
}
