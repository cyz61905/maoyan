package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午4:18
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {
    private Integer id;
    private String title;
    private String shopSign;
    private String city;
    private String address;
    private String phone;
    private Object services;
    private String longitudeLatitude;
}
