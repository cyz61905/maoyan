package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.dto.FilmDTO;
import com.cyz.maoyan.entity.Film;
import com.cyz.maoyan.mapper.FilmMapper;
import com.cyz.maoyan.service.FilmService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Map<String, List<Film>> getFilmHomePage() {
        Map<String, List<Film>> map = new HashMap<>();
        PageHelper.startPage(1, 10);
        List<Film> list0 = filmMapper.getFilmListByState(0);
        PageHelper.startPage(1, 10);
        List<Film> list1 = filmMapper.getFilmListByState(1);
        PageHelper.startPage(1, 3);
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
}
