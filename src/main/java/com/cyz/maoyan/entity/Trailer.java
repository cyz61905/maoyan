package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午7:31
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trailer {
    private Integer id;
    private String coverUrl;
    private String movieUrl;
    private String name;
    private Long thumbUp;
    private Integer filmId;
}
