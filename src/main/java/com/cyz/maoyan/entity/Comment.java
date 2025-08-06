package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:26
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private Integer id;
    private Integer filmId;
    private Integer userId;
    private String content;
    private Double score;
    private Date createTime;
    private Integer del;
}
