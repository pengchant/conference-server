package com.justcs.mapper;

import com.justcs.entity.MeetingCollect;

public interface MeetingCollectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeetingCollect record);

    int insertSelective(MeetingCollect record);

    MeetingCollect selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeetingCollect record);

    int updateByPrimaryKey(MeetingCollect record);
}