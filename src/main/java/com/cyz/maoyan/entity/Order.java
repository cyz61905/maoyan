package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午9:00
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer id;
    private Integer userId;
    private Integer price;
    private Date createTime;
    private String state;
    private Integer filmId;
    private Integer sessionId;
    private String seatList;
    private String seatRealList;
    private String orderNum;
    private Integer del;
}
