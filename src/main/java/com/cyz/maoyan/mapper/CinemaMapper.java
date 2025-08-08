package com.cyz.maoyan.mapper;

import com.cyz.maoyan.dto.CinemaDTO;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午4:01
 * @Version V1.0
 */

public interface CinemaMapper {
    List<String> cinemaNameList();

    List<CinemaDTO> selectCinemaList(String level, String brand);

    CinemaDTO selectCinemaById(Integer id);
}
