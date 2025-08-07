package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.dto.FilmDTO;
import com.cyz.maoyan.dto.ResultPage;
import com.cyz.maoyan.service.FilmService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午7:54
 * @Version V1.0
 */

@RestController
@RequestMapping("/film")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping("homepage")
    public AjaxResult getFilmHomePage() {
        return AjaxResult.success(filmService.getFilmHomePage());
    }

    @GetMapping("top100")
    public AjaxResult getFilmTop100() {
        return AjaxResult.success(filmService.getFilmTop100());
    }

    @GetMapping("list")
    public AjaxResult selectFilmList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                     Integer typeId, Integer regionId, String year,
                                     @RequestParam(value = "sort", required = false, defaultValue = "1") Integer sort){
        PageInfo<FilmDTO> filmPageInfo = filmService.selectFilmList(pageNum, pageSize, typeId, regionId, year, sort);
        return AjaxResult.success(new ResultPage(filmPageInfo.getTotal(), filmPageInfo.getPages(), filmPageInfo.getList()));
    }

    @GetMapping("{id}")
    public AjaxResult selectFilmDTOById(@PathVariable Integer id) {
        return AjaxResult.success(filmService.selectFilmDTOById(id));
    }

}
