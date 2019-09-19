package com.justcs.mapper;

import com.justcs.entity.UsrDutyKey;

public interface UsrDutyMapper {
    int deleteByPrimaryKey(UsrDutyKey key);

    int insert(UsrDutyKey record);

    int insertSelective(UsrDutyKey record);
}