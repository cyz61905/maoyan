package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午7:24
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Atlas {
    private Integer id;
    private Integer  filmId;
    private String  url;
}
