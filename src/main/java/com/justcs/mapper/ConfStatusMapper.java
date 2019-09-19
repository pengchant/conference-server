package com.justcs.mapper;

import com.justcs.entity.ConfStatus;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConfStatusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfStatus record);

    int insertSelective(ConfStatus record);

    ConfStatus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfStatus record);

    int updateByPrimaryKey(ConfStatus record);


    /**
     * 查询所有的会议状态信息
     * @param confstatus
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            "select * from confstatus",
            "where 1 = 1",
            // 判断条件
            "<if test='confstatus !=null and confstatus!=&apos;&apos;'>",
            "and confstatus like CONCAT(CONCAT('%', #{confstatus}), '%')",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<ConfStatus> selectConfStatus(@Param("confstatus") String confstatus, @Param("sortby") String sortby, @Param("order") String order);


    /**
     * 批量删除会议状态信息
     * @param confattrs
     * @return
     */
    @Delete({
            "<script>",
            "delete from confstatus",
            "where id in",
            "<foreach collection='ids' item='arr' open='(' separator=',' close=')'>",
            "#{arr}",
            "</foreach>",
            "</script>"
    })
    int batchDeleteConfStatus(@Param("ids") int[] confattrs);
}