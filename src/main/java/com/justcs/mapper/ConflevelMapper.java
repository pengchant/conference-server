package com.justcs.mapper;

import com.justcs.entity.Conflevel;
import com.justcs.entity.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConflevelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Conflevel record);

    int insertSelective(Conflevel record);

    Conflevel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Conflevel record);

    int updateByPrimaryKey(Conflevel record);


    @Select("select * from conflevel")
    public List<Conflevel> selectAllConflevel();

    /**
     * 查询所有的会议级别信息
     * @param levelname
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            "select * from conflevel",
            "where 1 = 1",
            // 判断条件
            "<if test='levelname !=null and levelname!=&apos;&apos;'>",
            "and levelname like CONCAT(CONCAT('%', #{levelname}), '%')",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<Conflevel> selectConfLevels(@Param("levelname") String levelname, @Param("sortby") String sortby, @Param("order") String order);


    /**
     * 批量删除会议级别信息
     * @param conflevels
     * @return
     */
    @Delete({
            "<script>",
            "delete from conflevel",
            "where id in",
            "<foreach collection='ids' item='arr' open='(' separator=',' close=')'>",
            "#{arr}",
            "</foreach>",
            "</script>"
    })
    int batchDeleteConfLevel(@Param("ids") int[] conflevels);
}