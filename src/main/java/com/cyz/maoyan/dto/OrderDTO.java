package com.cyz.maoyan.dto;

import com.cyz.maoyan.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午9:14
 * @Version V1.0
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDTO extends Order {
    private String cinemaName;
    private String filmName;
    private Date orderCreateTime;
    private Integer orderId;
    private String playTime;
    private String seatList;
    private String seatRealList;
    private String session;
    private String pay;
    private String cinemaAddress;
    private String phone;
}
