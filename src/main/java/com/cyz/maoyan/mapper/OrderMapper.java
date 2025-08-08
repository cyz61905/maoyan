package com.cyz.maoyan.mapper;

import com.cyz.maoyan.dto.OrderDTO;
import com.cyz.maoyan.dto.OrderDetailDTO;
import com.cyz.maoyan.entity.Order;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午9:01
 * @Version V1.0
 */

public interface OrderMapper {
    int addOrder(Order order);
    OrderDTO selectOrderById(Integer id);
    int cancelOrder(Integer id);
    int deleteOrder(Integer id);
    List<Order> selectOrderListByUserId(Integer userId);
}
