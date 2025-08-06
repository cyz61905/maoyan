package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午9:26
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserWantFilm {
    private Integer id;
    private Integer userId;
    private Integer filmId;
}
