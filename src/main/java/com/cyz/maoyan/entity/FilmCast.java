package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午7:27
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmCast {
    private Integer id;
    private String position;
    private String realName;
    private String role;
    private String imgUrl;
    private Integer filmId;
    private String positionEnglish;
}
