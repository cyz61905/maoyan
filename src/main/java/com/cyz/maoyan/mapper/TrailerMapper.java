package com.cyz.maoyan.mapper;

import com.cyz.maoyan.entity.Trailer;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午7:57
 * @Version V1.0
 */

public interface TrailerMapper {
    List<Trailer> getTrailerListByFilmId(Integer filmId);
}
