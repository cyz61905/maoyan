package com.cyz.maoyan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午8:39
 * @Version V1.0
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CinemaFilmSession {
    private Integer id;
    private Integer filmId;
    private Integer cinemaId;
    private Date playTime;
    private Date endTime;
    private String language;
    private String screeningRoom;
    private Integer price;
    private String seat;
}
