package com.cyz.maoyan.service;

import com.cyz.maoyan.entity.UserWantFilm;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午9:28
 * @Version V1.0
 */

public interface UserWantFilmService {
    UserWantFilm selectUserWantFilmByUserIdAndFilmId(Integer userId, Integer filmId);

    int addUserWantFilm(UserWantFilm userWantFilm);

    int deleteUserWantFilm(Integer userId, Integer filmId);
}
