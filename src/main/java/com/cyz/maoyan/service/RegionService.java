package com.cyz.maoyan.service;

import com.cyz.maoyan.entity.Region;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午9:05
 * @Version V1.0
 */

public interface RegionService {
    PageInfo<Region> getRegionList(Integer pageNum, Integer pageSize);
}
