package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.service.CinemaFilmSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午8:45
 * @Version V1.0
 */

@RestController
@RequestMapping("/cinemaFilmSession")
public class CinemaFilmSessionController {
    @Autowired
    private CinemaFilmSessionService cinemaFilmSessionService;

    @GetMapping("list")
    public AjaxResult selectCinemaFilmSessionByCinemaIdAndFilmId(Integer cinemaId, Integer filmId) {
        return AjaxResult.success(cinemaFilmSessionService.selectCinemaFilmSessionByCinemaIdAndFilmId(cinemaId, filmId));
    }
}
