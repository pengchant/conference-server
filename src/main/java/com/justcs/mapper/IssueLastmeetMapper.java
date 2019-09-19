package com.justcs.mapper;

import com.justcs.entity.IssueLastmeet;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IssueLastmeetMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(IssueLastmeet record);

    int insertSelective(IssueLastmeet record);

    IssueLastmeet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IssueLastmeet record);

    int updateByPrimaryKey(IssueLastmeet record);


    /**
     * 批量录入上次会议所提议题
     * @param issueLastmeetList
     * @param collid
     * @return
     */
    @Insert({
            "<script>",
            "insert into issuelastmeet(maincontent, meetcollid)",
            "values",
            "<foreach collection='lasts' index='index' item='item' separator=',' >",
            "(#{item.maincontent}, #{collid})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("lasts") List<IssueLastmeet> issueLastmeetList, @Param("collid")Integer collid);
}