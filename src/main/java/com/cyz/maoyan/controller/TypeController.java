package com.cyz.maoyan.controller;

import com.cyz.maoyan.dto.AjaxResult;
import com.cyz.maoyan.dto.ResultPage;
import com.cyz.maoyan.entity.Type;
import com.cyz.maoyan.service.TypeService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午9:16
 * @Version V1.0
 */

@RestController
@RequestMapping("type")
public class TypeController {
    @Autowired
    private TypeService typeService;

    @GetMapping("list")
    public AjaxResult getTypeList(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(value = "pageSize", required = false, defaultValue = "30")Integer pageSize) {
        PageInfo<Type> typeList = typeService.getTypeList(pageNum,pageSize);
        ResultPage resultPage = new ResultPage(typeList.getTotal(), typeList.getPages(), typeList.getList());
        return AjaxResult.success(resultPage);
    }
}
