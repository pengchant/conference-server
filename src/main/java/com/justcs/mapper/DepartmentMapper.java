package com.justcs.mapper;

import com.justcs.entity.Department;
import com.justcs.entity.Mposition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);


    /**
     * 查询所有的部门
     * @return
     */
    @Select("select * from department")
    List<Department> selectAllDepartment();

    /**
     * 查询所有的职位信息
     * @param departname
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            "select * from department",
            "where 1 = 1",
            // 判断条件
            "<if test='departname !=null and departname!=&apos;&apos;'>",
            "and departname like CONCAT(CONCAT('%', #{departname}), '%')",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<Department> selectDepartments(@Param("departname") String departname, @Param("sortby") String sortby, @Param("order") String order);


    /**
     * 批量删除学期信息
     * @param departments
     * @return
     */
    @Delete({
            "<script>",
            "delete from department",
            "where id in",
            "<foreach collection='ids' item='arr' open='(' separator=',' close=')'>",
            "#{arr}",
            "</foreach>",
            "</script>"
    })
    int batchDeletePosition(@Param("ids") int[] departments);
}