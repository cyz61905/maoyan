package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.entity.Order;
import com.cyz.maoyan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午9:11
 * @Version V1.0
 */

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("add")
    public AjaxResult addOrder(@RequestBody Order order) {
        return AjaxResult.success(orderService.addOrder(order));
    }

    @GetMapping("cancel")
    public AjaxResult cancelOrder(Integer id) {
        int i = orderService.cancelOrder(id);
        if (i == 0) {
            return AjaxResult.error("取消失败");
        }
        return AjaxResult.success();
    }

    @DeleteMapping("delete/{id}")
    public AjaxResult deleteOrder(@PathVariable Integer id) {
        int i = orderService.deleteOrder(id);
        if (i == 0) {
            return AjaxResult.error("删除失败");
        }
        return AjaxResult.success();
    }

    @GetMapping("list")
    public AjaxResult selectOrderListByUserId(Integer userId) {
        return AjaxResult.success(orderService.selectOrderListByUserId(userId));
    }

    @GetMapping("{id}")
    public AjaxResult selectOrderById(@PathVariable Integer id) {
        return AjaxResult.success(orderService.selectOrderById(id));
    }

}
