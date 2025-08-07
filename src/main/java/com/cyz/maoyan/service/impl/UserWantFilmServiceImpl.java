package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.entity.Film;
import com.cyz.maoyan.entity.UserWantFilm;
import com.cyz.maoyan.mapper.FilmMapper;
import com.cyz.maoyan.mapper.UserWantFilmMapper;
import com.cyz.maoyan.service.UserWantFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private FilmMapper filmMapper;

    @Override
    public UserWantFilm selectUserWantFilmByUserIdAndFilmId(Integer userId, Integer filmId) {
        return userWantFilmMapper.selectUserWantFilmByUserIdAndFilmId(userId, filmId);
    }

    @Override
    @Transactional
    public int addUserWantFilm(UserWantFilm userWantFilm) {
        UserWantFilm uwf = userWantFilmMapper.selectUserWantFilmByUserIdAndFilmId(userWantFilm.getUserId(), userWantFilm.getFilmId());
        if (uwf == null) {
            try {
                userWantFilmMapper.addUserWantFilm(userWantFilm);
                Film film = filmMapper.selectFilmById(userWantFilm.getFilmId());
                film.setWantSee(film.getWantSee() + 1);
                filmMapper.updateFilm(film);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            return 0;
        }
    }

    @Override
    @Transactional
    public int deleteUserWantFilm(Integer userId, Integer filmId) {
        UserWantFilm uwf = userWantFilmMapper.selectUserWantFilmByUserIdAndFilmId(userId, filmId);
        if (uwf != null) {
            try {
                userWantFilmMapper.deleteUserWantFilm(userId, filmId);
                Film film = filmMapper.selectFilmById(filmId);
                film.setWantSee(film.getWantSee() - 1);
                filmMapper.updateFilm(film);
                return 1;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        } else {
            return 0;
        }
    }
}
