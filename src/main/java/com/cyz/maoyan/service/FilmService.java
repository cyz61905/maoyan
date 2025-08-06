package com.cyz.maoyan.service;

import com.cyz.maoyan.dto.FilmDTO;
import com.cyz.maoyan.entity.Film;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午7:39
 * @Version V1.0
 */

public interface FilmService {
    Map<String, List<Film>> getFilmHomePage();
    List<FilmDTO> getFilmTop100();
    PageInfo<FilmDTO> selectFilmList(Integer pageNum, Integer pageSize, Integer typeId, Integer regionId, String year, Integer sort);
    FilmDTO selectFilmById(Integer id);
}
