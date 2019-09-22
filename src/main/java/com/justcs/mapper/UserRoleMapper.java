package com.justcs.mapper;

import com.justcs.entity.UserRoleKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleMapper {
    int deleteByPrimaryKey(UserRoleKey key);

    int insert(UserRoleKey record);

    int insertSelective(UserRoleKey record);

    /**
     * 批量插入用户角色信息
     * @param accid
     * @return
     */
    @Insert({
            "<script>",
            "insert into userrole(accid, roleid)",
            "values",
            "<foreach item='item' index='index' collection='roles' separator=','>",
            "(#{accid}, #{item})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("accid") Integer accid, @Param("roles") List<Integer> roles);


    /**
     * 删除用户的所有角色
     * @param accid
     * @return
     */
    @Delete({
            "delete from userrole where accid = #{accid}"
    })
    int deleteUsrRoles(@Param("accid")Integer accid);
}