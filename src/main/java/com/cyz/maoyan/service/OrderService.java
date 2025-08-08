package com.cyz.maoyan.service;

import com.cyz.maoyan.dto.OrderDTO;
import com.cyz.maoyan.dto.OrderDetailDTO;
import com.cyz.maoyan.entity.Order;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午9:03
 * @Version V1.0
 */

public interface OrderService {
    OrderDTO addOrder(Order order);
    int cancelOrder(Integer id);
    int deleteOrder(Integer id);
    List<Map<String, Object>> selectOrderListByUserId(Integer userId);
    OrderDTO selectOrderById(Integer id);
}
