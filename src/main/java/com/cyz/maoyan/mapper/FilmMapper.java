package com.cyz.maoyan.mapper;

import com.cyz.maoyan.dto.FilmDTO;
import com.cyz.maoyan.entity.Film;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午7:04
 * @Version V1.0
 */

public interface FilmMapper {
    List<Film> getFilmListByState(Integer state);
    List<Film> getFilmExpectation();
    List<FilmDTO> getFilmTop100();
    List<FilmDTO> selectFilmList(Integer typeId, Integer regionId, String begin, String end, Integer sort);
}
