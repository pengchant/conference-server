package com.justcs.mapper;

import com.justcs.entity.MediaResource;

public interface MediaResourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MediaResource record);

    int insertSelective(MediaResource record);

    MediaResource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MediaResource record);

    int updateByPrimaryKey(MediaResource record);
}