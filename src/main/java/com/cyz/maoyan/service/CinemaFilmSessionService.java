package com.cyz.maoyan.service;

import com.cyz.maoyan.entity.CinemaFilmSession;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午8:43
 * @Version V1.0
 */

public interface CinemaFilmSessionService {
    List<CinemaFilmSession> selectCinemaFilmSessionByCinemaIdAndFilmId(Integer cinemaId, Integer filmId);
}
