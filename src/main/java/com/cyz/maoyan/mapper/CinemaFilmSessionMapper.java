package com.cyz.maoyan.mapper;

import com.cyz.maoyan.entity.CinemaFilmSession;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午8:40
 * @Version V1.0
 */

public interface CinemaFilmSessionMapper {
    List<CinemaFilmSession> selectCinemaFilmSessionByCinemaIdAndFilmId(Integer cinemaId, Integer filmId);
    Integer getPriceById(Integer id);
    int updateCinemaFilmSessionSeat(CinemaFilmSession cinemaFilmSession);
    CinemaFilmSession selectCinemaFilmSessionById(Integer id);
    Integer getCinemaIdBySessionId(Integer id);
}
