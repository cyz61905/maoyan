package com.cyz.maoyan.mapper;

import com.cyz.maoyan.entity.FilmCast;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午8:01
 * @Version V1.0
 */

public interface FilmCastMapper {
    List<FilmCast> getFilmCastListByFilmId(Integer filmId);
}
