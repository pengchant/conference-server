package com.justcs.mapper;

import com.justcs.entity.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);


    /**
     * 查询所有角色
     * @return
     */
    @Select({
            "select * from role"
    })
    List<Role> selectAllRoles();
}