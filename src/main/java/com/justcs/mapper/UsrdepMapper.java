package com.justcs.mapper;

import com.justcs.entity.UsrdepKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsrdepMapper {
    int deleteByPrimaryKey(UsrdepKey key);

    int insert(UsrdepKey record);

    int insertSelective(UsrdepKey record);

    /**
     * 批量插入用户部门信息
     * @param usrid
     * @param departments
     * @return
     */
    @Insert({
            "<script>",
            "insert into usrdep(usrid, depid)",
            "values",
            "<foreach item='item' index='index' collection='departments' separator=','>",
            "(#{usrid}, #{item})",
            "</foreach>",
            "</script>"
    })
    int batchInsertUsrdep(@Param("usrid")Integer usrid, @Param("departments") List<Integer> departments);

    /**
     * 删除用户的所有部门信息
     * @param usrid
     * @return
     */
    @Delete({
        "delete from usrdep where usrid = #{usrid}"
    })
    int deleteUsrDeps(@Param("usrid")Integer usrid);

}