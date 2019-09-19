package com.justcs.mapper;

import com.justcs.entity.ConfTitle;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConfTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfTitle record);

    int insertSelective(ConfTitle record);

    ConfTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfTitle record);

    int updateByPrimaryKey(ConfTitle record);


    /**
     * 查询某会议下的所有的会议议题详情表
     * @param confid
     * @return
     */
    @Select({
            "select * from conftitle where confid=#{confid}"
    })
    List<ConfTitle> selectCfTitlesByConfId(@Param(value = "confid") String confid);


    /**
     * 查询会议议题表
     * @param confid
     * @param conftitle
     * @return
     */
    @Select({
            "select *\n" +
                    "from conftitle\n" +
                    "where confid=#{confid} and conftitlecnt=#{conftitle}"
    })
    ConfTitle selectContians(@Param(value = "confid")String confid, @Param(value = "conftitle")String conftitle);


}