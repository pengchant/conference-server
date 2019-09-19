package com.justcs.mapper;

import com.justcs.entity.ConfAttrKey;
import com.justcs.entity.ConfAttributes;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ConfAttrMapper {
    int deleteByPrimaryKey(ConfAttrKey key);

    int insert(ConfAttrKey record);

    int insertSelective(ConfAttrKey record);

    /**
     * 批量录入会议的属性
     * @param lists
     * @param confid
     * @return
     */
    @Insert({
            "<script>",
            "insert into confattr(confid, confattrid)",
            "values",
            "<foreach collection='lists' index='index' item='item' separator=','>",
            "(#{confid},#{item.id})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("lists") List<ConfAttributes> lists, @Param("confid")Integer confid);
}