package com.justcs.mapper;

import com.justcs.entity.Mposition;
import com.justcs.entity.Semester;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MpositionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mposition record);

    int insertSelective(Mposition record);

    Mposition selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mposition record);

    int updateByPrimaryKey(Mposition record);

    /**
     * 查询所有的职位
     * @return
     */
    @Select("select * from mposition")
    List<Mposition> selectAllPosition();

    /**
     * 查询所有的职位信息
     * @param position
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            "select * from mposition",
            "where 1 = 1",
            // 判断条件
            "<if test='position !=null and position!=&apos;&apos;'>",
            "and position like CONCAT(CONCAT('%', #{position}), '%')",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<Mposition> selectPosition(@Param("position") String position, @Param("sortby") String sortby, @Param("order") String order);


    /**
     * 批量删除学期信息
     * @param semesters
     * @return
     */
    @Delete({
            "<script>",
            "delete from mposition",
            "where id in",
            "<foreach collection='ids' item='arr' open='(' separator=',' close=')'>",
            "#{arr}",
            "</foreach>",
            "</script>"
    })
    int batchDeletePosition(@Param("ids") int[] semesters);


}