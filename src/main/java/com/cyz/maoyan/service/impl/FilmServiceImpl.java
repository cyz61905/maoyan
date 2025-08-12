package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.dto.FilmDTO;
import com.cyz.maoyan.entity.Film;
import com.cyz.maoyan.entity.FilmCast;
import com.cyz.maoyan.mapper.*;
import com.cyz.maoyan.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午7:41
 * @Version V1.0
 */

@Service
public class FilmServiceImpl implements FilmService {
    @Autowired
    private FilmMapper filmMapper;
    @Autowired
    private AtlasMapper atlasMapper;
    @Autowired
    private TypeMapper typeMapper;
    @Autowired
    private TrailerMapper trailerMapper;
    @Autowired
    private FilmCastMapper filmCastMapper;

    @Override
    public Map<String, List<? extends Film>> getFilmHomePage() {
        Map<String, List<?extends Film>> map = new HashMap<>();
        PageHelper.startPage(1, 10);
        List<FilmDTO> list0 = filmMapper.getFilmListByState(0);
        PageHelper.startPage(1, 10);
        List<FilmDTO> list1 = filmMapper.getFilmListByState(1);
        PageHelper.startPage(1, 10);
        List<Film> list2 = filmMapper.getFilmExpectation();
        map.put("noPlay", list0);
        map.put("playing", list1);
        map.put("expectation", list2);
        return map;
    }

    @Override
    public List<FilmDTO> getFilmTop100() {
        PageHelper.startPage(1, 10);
        return filmMapper.getFilmTop100();
    }

    @Override
    public PageInfo<FilmDTO> selectFilmList(Integer pageNum, Integer pageSize, Integer typeId, Integer regionId, String year, Integer sort) {
        PageHelper.startPage(pageNum, pageSize);
        String begin = null;
        String end = null;
        if (year != null && !year.isBlank()) {
            String[] str = year.split("-");
            begin = str[0] + "-01-01";
            if (str.length == 2) {
                end = str[1] + "-12-31";
            } else {
                end = str[0] + "-12-31";
            }
        }
        List<FilmDTO> list = filmMapper.selectFilmList(typeId, regionId, begin, end, sort);
        return new PageInfo<>(list);
    }

    @Override
    public FilmDTO selectFilmDTOById(Integer id) {
        FilmDTO filmDTO = filmMapper.selectFilmDTOById(id);
        filmDTO.setAtlasList(atlasMapper.getAtlasListByFilmId(id));
        filmDTO.setTypeList(typeMapper.getTypeListByFilmId(id));
        filmDTO.setTrailerList(trailerMapper.getTrailerListByFilmId(id));
        List<FilmCast> list = filmCastMapper.getFilmCastListByFilmId(id);
        Map<String, List<FilmCast>> map = new HashMap<>();
        for (FilmCast filmCast : list) {
            String key = filmCast.getPositionEnglish();
            if(map.containsKey(key)){
                map.get(key).add(filmCast);
            }else {
                List<FilmCast> list1 = new ArrayList<>();
                list1.add(filmCast);
                map.put(key, list1);
            }
        }
        filmDTO.setFilmCastList(map);
        return filmDTO;
    }
}
