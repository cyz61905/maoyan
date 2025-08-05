package com.cyz.maoyan.service;

import com.cyz.maoyan.entity.Type;
import com.github.pagehelper.PageInfo;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午9:14
 * @Version V1.0
 */

public interface TypeService {
    PageInfo<Type> getTypeList(Integer pageNum, Integer pageSize);
}
