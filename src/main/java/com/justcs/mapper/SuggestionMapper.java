package com.justcs.mapper;

import com.justcs.entity.IssueCurmeet;
import com.justcs.entity.Suggestion;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SuggestionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Suggestion record);

    int insertSelective(Suggestion record);

    Suggestion selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Suggestion record);

    int updateByPrimaryKey(Suggestion record);

    /**
     * 批量录入建议解决方案
     * @param suggestionList
     * @param collid
     * @return
     */
    @Insert({
            "<script>",
            "insert into suggestion(maincontent, meetcollid)",
            "values",
            "<foreach collection='lists' index='index' item='item' separator=','>",
            "(#{item.maincontent}, #{collid})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("lists") List<Suggestion> suggestionList, @Param("collid")Integer collid);
}