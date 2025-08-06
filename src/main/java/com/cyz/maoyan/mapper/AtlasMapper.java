package com.cyz.maoyan.mapper;

import com.cyz.maoyan.entity.Atlas;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/6 下午7:52
 * @Version V1.0
 */

public interface AtlasMapper {
    List<Atlas> getAtlasListByFilmId(Integer filmId);
}
