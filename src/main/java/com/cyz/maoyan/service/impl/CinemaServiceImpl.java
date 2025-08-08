package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.dto.CinemaDTO;
import com.cyz.maoyan.dto.FilmDTO;
import com.cyz.maoyan.mapper.CinemaMapper;
import com.cyz.maoyan.mapper.FilmMapper;
import com.cyz.maoyan.service.CinemaService;
import com.cyz.maoyan.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午4:08
 * @Version V1.0
 */

@Service
public class CinemaServiceImpl implements CinemaService {
    @Autowired
    private CinemaMapper cinemaMapper;
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private FilmService filmService;

    @Override
    public List<String> cinemaNameList() {
        return cinemaMapper.cinemaNameList();
    }

    @Override
    public PageInfo<CinemaDTO> selectCinemaList(Integer pageNum, Integer pageSize, String level, String brand) {
        PageHelper.startPage(pageNum, pageSize);
        List<CinemaDTO> list = cinemaMapper.selectCinemaList(level, brand);
        return new PageInfo<>(list);
    }

    @Override
    public CinemaDTO selectCinemaById(Integer id) {
        CinemaDTO cinemaDTO = cinemaMapper.selectCinemaById(id);
        List<FilmDTO> filmList = new ArrayList<>();
        List<Integer> filmIds = filmMapper.selectFilmIdsByCinemaId(id);
        for (Integer filmId : filmIds) {
            FilmDTO filmDTO = filmService.selectFilmDTOById(filmId);
            filmList.add(filmDTO);
        }
        cinemaDTO.setFilmList(filmList);
        return cinemaDTO;
    }
}
