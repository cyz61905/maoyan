package com.cyz.maoyan.mapper;

import com.cyz.maoyan.entity.Type;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午9:12
 * @Version V1.0
 */

public interface TypeMapper {
    List<Type> getTypeList();
    List<Type> getTypeListByFilmId(Integer filmId);
}
