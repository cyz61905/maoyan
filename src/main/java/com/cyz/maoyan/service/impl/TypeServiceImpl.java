package com.cyz.maoyan.service.impl;

import com.cyz.maoyan.entity.Type;
import com.cyz.maoyan.mapper.TypeMapper;
import com.cyz.maoyan.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author cyz
 * @Date 2025/8/5 下午9:15
 * @Version V1.0
 */

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeMapper typeMapper;
    @Override
    public PageInfo<Type> getTypeList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Type> list = typeMapper.getTypeList();
        return new PageInfo<>(list);
    }
}
