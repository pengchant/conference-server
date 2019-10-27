package com.justcs.mapper;

import com.justcs.entity.Usrsecdep;

public interface UsrsecdepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usrsecdep record);

    int insertSelective(Usrsecdep record);

    Usrsecdep selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Usrsecdep record);

    int updateByPrimaryKey(Usrsecdep record);
}