package com.justcs.mapper;

import com.justcs.entity.Duty;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DutyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Duty record);

    int insertSelective(Duty record);

    Duty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKey(Duty record);

    @Select("select * from duty")
    List<Duty> selectAllDutys();
}