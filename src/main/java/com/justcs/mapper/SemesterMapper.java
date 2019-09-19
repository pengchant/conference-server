package com.justcs.mapper;

import com.justcs.entity.Semester;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SemesterMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Semester record);

    int insertSelective(Semester record);

    Semester selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Semester record);

    int updateByPrimaryKey(Semester record);


    /**
     * 查询所有学期
     * @return
     */
    @Select("select * from semester order by id desc")
    List<Semester> selectAllSemester();


    /**
     * 查询所有的学期信息
     * @param semsname
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            "select * from semester",
            "where 1 = 1",
            // 判断条件
            "<if test='semsname !=null and semsname!=&apos;&apos;'>",
                "and semestername like CONCAT(CONCAT('%', #{semsname}), '%')",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
                "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<Semester> selectSemester(@Param("semsname") String semsname, @Param("sortby") String sortby, @Param("order") String order);


    /**
     * 批量删除学期信息
     * @param semesters
     * @return
     */
    @Delete({
            "<script>",
            "delete from semester",
            "where id in",
            "<foreach collection='ids' item='arr' open='(' separator=',' close=')'>",
            "#{arr}",
            "</foreach>",
            "</script>"
    })
    int batchDeleteSemester(@Param("ids") int[] semesters);
}