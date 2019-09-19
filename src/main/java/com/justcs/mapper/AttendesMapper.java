package com.justcs.mapper;

import com.justcs.entity.Attendes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AttendesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Attendes record);

    int insertSelective(Attendes record);

    Attendes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Attendes record);

    int updateByPrimaryKey(Attendes record);

    /**
     * 批量录入会议的属性
     * @param lists
     * @param confid
     * @return
     */
    @Insert({
            "<script>",
            "insert into attendes(workerid, hasattend, confid)",
            "values",
            "<foreach collection='lists' index='index' item='item' separator=','>",
            "(#{item.workerid}, #{item.hasattend}, #{confid})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("lists") List<Attendes> lists, @Param("confid")Integer confid);

    /**
     * 用户签到
     * @param Confid
     * @param workerid
     * @return
     */
    @Update({
            "update attendes",
            "set hasattend=#{status}",
            "where confid=#{confid} and workerid=#{workerid}"
    })
    int updateAttStatus(@Param("confid") String Confid, @Param("workerid")String  workerid, @Param("status")String status);

}