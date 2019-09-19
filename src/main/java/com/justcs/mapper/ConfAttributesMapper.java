package com.justcs.mapper;

import com.justcs.entity.ConfAttributes;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConfAttributesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConfAttributes record);

    int insertSelective(ConfAttributes record);

    ConfAttributes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConfAttributes record);

    int updateByPrimaryKey(ConfAttributes record);


    /**
     * 查询所有会议属性
     * @return
     */
    @Select("select * from confattributes")
    public List<ConfAttributes> selectAllConfAttrs();

    /**
     * 查询所有的会议属性信息
     * @param attrname
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            "select * from confattributes",
            "where 1 = 1",
            // 判断条件
            "<if test='attrname !=null and attrname!=&apos;&apos;'>",
            "and attrname like CONCAT(CONCAT('%', #{attrname}), '%')",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<ConfAttributes> selectConfAttrs(@Param("attrname") String attrname, @Param("sortby") String sortby, @Param("order") String order);


    /**
     * 批量删除会议属性信息
     * @param confattrs
     * @return
     */
    @Delete({
            "<script>",
            "delete from confattributes",
            "where id in",
            "<foreach collection='ids' item='arr' open='(' separator=',' close=')'>",
            "#{arr}",
            "</foreach>",
            "</script>"
    })
    int batchDeleteConfattr(@Param("ids") int[] confattrs);
}