package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.entity.CinemaFilmSession;
import com.cyz.maoyan.mapper.CinemaFilmSessionMapper;
import com.cyz.maoyan.service.CinemaFilmSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午8:44
 * @Version V1.0
 */

@Service
public class CinemaFilmSessionServiceImpl implements CinemaFilmSessionService {
    @Autowired
    private CinemaFilmSessionMapper cinemaFilmSessionMapper;

    @Override
    public List<CinemaFilmSession> selectCinemaFilmSessionByCinemaIdAndFilmId(Integer cinemaId, Integer filmId) {
        return cinemaFilmSessionMapper.selectCinemaFilmSessionByCinemaIdAndFilmId(cinemaId, filmId);
    }
}
