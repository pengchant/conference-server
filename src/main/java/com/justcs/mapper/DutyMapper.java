package com.justcs.mapper;

import com.justcs.entity.Duty;
import com.justcs.entity.Mposition;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DutyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Duty record);

    int insertSelective(Duty record);

    Duty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Duty record);

    int updateByPrimaryKey(Duty record);

    @Select("select * from duty")
    List<Duty> selectAllDutys();


    /**
     * 查询所有的职位1信息
     * @param position
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            "select * from duty",
            "where 1 = 1",
            // 判断条件
            "<if test='position !=null and position!=&apos;&apos;'>",
            "and duty like CONCAT(CONCAT('%', #{position}), '%')",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<Duty> selectDuty(@Param("position") String position, @Param("sortby") String sortby, @Param("order") String order);


    /**
     * 批量删除职位信息
     * @param ids
     * @return
     */
    @Delete({
            "<script>",
            "delete from duty",
            "where id in",
            "<foreach collection='ids' item='arr' open='(' separator=',' close=')'>",
            "#{arr}",
            "</foreach>",
            "</script>"
    })
    int batchDeleteDuty(@Param("ids") int[] ids);
}