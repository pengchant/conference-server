package com.justcs.mapper;

import com.justcs.entity.OpConflog;

public interface OpConflogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OpConflog record);

    int insertSelective(OpConflog record);

    OpConflog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OpConflog record);

    int updateByPrimaryKey(OpConflog record);
}