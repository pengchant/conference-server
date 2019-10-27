package com.justcs.mapper;

import com.justcs.entity.Depchildrens;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DepchildrensMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Depchildrens record);

    int insertSelective(Depchildrens record);

    Depchildrens selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Depchildrens record);

    int updateByPrimaryKey(Depchildrens record);

    /**
     * 根据部门的编号查询二级部门的信息
     *
     * @param depid
     * @return
     */
    @Select({
            "<script>",
            "select * from depchildrens",
            "where 1 = 1",
            // 判断条件
            "<if test='depid !=null and depid!=&apos;&apos;'>",
            "and departid = #{depid}",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<Depchildrens> selectByDepId(@Param("depid") String depid,
                                     @Param("sortby") String sortby,
                                     @Param("order") String order);
}