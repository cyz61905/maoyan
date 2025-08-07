package com.cyz.maoyan.mapper;

import com.cyz.maoyan.entity.UserWantFilm;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午9:27
 * @Version V1.0
 */

public interface UserWantFilmMapper {
    UserWantFilm selectUserWantFilmByUserIdAndFilmId(Integer userId, Integer filmId);
    int addUserWantFilm(UserWantFilm userWantFilm);
    int deleteUserWantFilm(Integer userId, Integer filmId);
}
