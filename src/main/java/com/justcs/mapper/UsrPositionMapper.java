package com.justcs.mapper;

import com.justcs.entity.UsrPositionKey;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsrPositionMapper {
    int deleteByPrimaryKey(UsrPositionKey key);

    int insert(UsrPositionKey record);

    int insertSelective(UsrPositionKey record);

    /**
     * 批量插入用户职位表信息
     * @param usrid
     * @return
     */
    @Insert({
            "<script>",
            "insert into usrposition(usrid, posid)",
            "values",
            "<foreach item='item' index='index' collection='positions' separator=','>",
            "(#{usrid}, #{item})",
            "</foreach>",
            "</script>"
    })
    int batchInsert(@Param("usrid") Integer usrid, @Param("positions") List<Integer> positions);
}