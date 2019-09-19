package com.justcs.mapper;

import com.justcs.entity.ConfTitleRecord;

public interface ConfTitleRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfTitleRecord record);

    int insertSelective(ConfTitleRecord record);

    ConfTitleRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfTitleRecord record);

    int updateByPrimaryKeyWithBLOBs(ConfTitleRecord record);

    int updateByPrimaryKey(ConfTitleRecord record);
}