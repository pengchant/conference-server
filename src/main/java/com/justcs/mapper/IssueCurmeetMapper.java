package com.justcs.mapper;

import com.justcs.entity.IssueCurmeet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IssueCurmeetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IssueCurmeet record);

    int insertSelective(IssueCurmeet record);

    IssueCurmeet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IssueCurmeet record);

    int updateByPrimaryKey(IssueCurmeet record);

    /**
     * 批量录入本次会议所提议题
     * @param issueCurmeetList
     * @param collid
     * @return
     */
    @Insert({
            "<script>",
            "insert into issuecurmeet(mainconent, meetcollid)",
            "values",
            "<foreach collection='lists' index='index' item='item' separator=',' >",
            "(#{item.mainconent}, #{collid})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("lists") List<IssueCurmeet> issueCurmeetList, @Param("collid")Integer collid);
}