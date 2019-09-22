package com.justcs.mapper;

import com.justcs.entity.UsrDutyKey;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsrDutyMapper {
    int deleteByPrimaryKey(UsrDutyKey key);

    int insert(UsrDutyKey record);

    int insertSelective(UsrDutyKey record);

    /**
     * 批量插入用户职务表信息
     * @param usrid
     * @return
     */
    @Insert({
            "<script>",
            "insert into usrduty(usrid, dutyid)",
            "values",
            "<foreach item='item' index='index' collection='dutys' separator=','>",
            "(#{usrid}, #{item})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("usrid") Integer usrid, @Param("dutys") List<Integer> dutys);


    /**
     * 删除用户的所有职务
     * @param usrid
     * @return
     */
    @Delete({
            "delete from usrduty where usrid = #{usrid}"
    })
    int deleteUsrDutys(@Param("usrid")Integer usrid);
}