package com.cyz.maoyan.service;

import com.cyz.maoyan.dto.CinemaDTO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午4:08
 * @Version V1.0
 */

public interface CinemaService {
    List<String> cinemaNameList();

    PageInfo<CinemaDTO> selectCinemaList(Integer pageNum, Integer pageSize, String level, String brand);

    CinemaDTO selectCinemaById(Integer id);
}
