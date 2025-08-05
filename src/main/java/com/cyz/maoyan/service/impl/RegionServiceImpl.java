package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.entity.Region;
import com.cyz.maoyan.mapper.RegionMapper;
import com.cyz.maoyan.service.RegionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午9:05
 * @Version V1.0
 */

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private RegionMapper regionMapper;

    @Override
    public PageInfo<Region> getRegionList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Region> list = regionMapper.getRegionList();
        return new PageInfo<>(list);
    }
}
