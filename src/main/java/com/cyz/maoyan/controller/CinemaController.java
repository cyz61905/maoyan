package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.dto.CinemaDTO;
import com.cyz.maoyan.dto.ResultPage;
import com.cyz.maoyan.service.CinemaService;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/8 下午4:09
 * @Version V1.0
 */

@RestController
@RequestMapping("/cinema")
public class CinemaController {
    @Autowired
    private CinemaService cinemaService;

    @GetMapping("/cinemaNameList")
    public AjaxResult cinemaNameList() {
        return AjaxResult.success(cinemaService.cinemaNameList());
    }

    @GetMapping("cinemaLevelList")
    public AjaxResult cinemaLevelList() {
        List<String> list = List.of("IMAX厅", "杜比全景声厅", "RealD厅", "LUXE巨幕厅", "4DX厅", "DTS:X临境音厅", "亲子厅", "4K厅", "4D厅", "60帧厅", "巨幕厅", "CINITY厅", "激光厅", "ALPD Pro高亮厅", "PRIME厅");
        return AjaxResult.success(list);
    }

    @GetMapping("list")
    public AjaxResult list(Integer pageNum, Integer pageSize, String level, String brand) {
        String l = StringUtil.isEmpty(level)? null : level.substring(0, level.length() - 1);
        String b = StringUtil.isEmpty(brand)? null : brand;
        PageInfo<CinemaDTO> pageInfo = cinemaService.selectCinemaList(pageNum, pageSize, l, b);
        System.out.println("pageInfo = " + pageInfo);
        return AjaxResult.success(new ResultPage(pageInfo.getTotal(), pageInfo.getPages(), pageInfo.getList()));
    }

    @GetMapping("{id}")
    public AjaxResult selectCinemaById(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();
        map.put("cinema", cinemaService.selectCinemaById(id));
        return AjaxResult.success(map);
    }
}
