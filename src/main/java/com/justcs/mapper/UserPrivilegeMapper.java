package com.justcs.mapper;

import com.justcs.entity.UserPrivilegeKey;

public interface UserPrivilegeMapper {
    int deleteByPrimaryKey(UserPrivilegeKey key);

    int insert(UserPrivilegeKey record);

    int insertSelective(UserPrivilegeKey record);
}