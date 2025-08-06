package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.entity.UserWantFilm;
import com.cyz.maoyan.mapper.UserWantFilmMapper;
import com.cyz.maoyan.service.UserWantFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午9:29
 * @Version V1.0
 */

@Service
public class UserWantFilmServiceImpl implements UserWantFilmService {
    @Autowired
    private UserWantFilmMapper userWantFilmMapper;

    @Override
    public UserWantFilm selectUserWantFilmByUserIdAndFilmId(Integer userId, Integer filmId) {
        return userWantFilmMapper.selectUserWantFilmByUserIdAndFilmId(userId, filmId);
    }

    @Override
    public void addUserWantFilm(UserWantFilm userWantFilm) {
        UserWantFilm uwf = userWantFilmMapper.selectUserWantFilmByUserIdAndFilmId(userWantFilm.getUserId(), userWantFilm.getFilmId());
        if (uwf == null) {
            userWantFilmMapper.addUserWantFilm(userWantFilm);
        }
    }

    @Override
    public void deleteUserWantFilm(Integer userId, Integer filmId) {
        UserWantFilm uwf = userWantFilmMapper.selectUserWantFilmByUserIdAndFilmId(userId, filmId);
        if (uwf != null) {
            userWantFilmMapper.deleteUserWantFilm(userId, filmId);
        }
    }
}
