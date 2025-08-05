package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.dto.ResultPage;
import com.cyz.maoyan.entity.Region;
import com.cyz.maoyan.service.RegionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午9:06
 * @Version V1.0
 */

@RestController
@RequestMapping("/region")
public class RegionController {
    @Autowired
    private RegionService regionService;

    @GetMapping("list")
    public AjaxResult getRegionList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", required = false, defaultValue = "30")Integer pageSize) {
        PageInfo<Region> regionList = regionService.getRegionList(pageNum, pageSize);
        ResultPage resultPage = new ResultPage(regionList.getTotal(), regionList.getPages(), regionList.getList());
        return AjaxResult.success(resultPage);
    }
}
