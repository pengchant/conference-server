package com.justcs.mapper;

import com.justcs.entity.Userinfo;
import com.justcs.form.UserSelectView;
import com.justcs.view.CurDepUsrView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Userinfo record);

    int insertSelective(Userinfo record);

    Userinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Userinfo record);

    int updateByPrimaryKey(Userinfo record);


    /**
     * 查询当时部门的编号，和相关职务的记录
     *
     * @param depid
     * @param positions
     * @param dutys
     * @return
     */
    @Select({
            "<script>",
            "select u.accid as workerid, u.usrname as usrname",
            "from userinfo u \n",

            // 判断条件
            "<if test='depid !=null'>",
            "join (\n" +
                    "\tselect usrid\n" +
                    "\tfrom usrdep\n" +
                    "\twhere depid=#{depid}\n" +
                    ") d on (u.accid=d.usrid)",
            "</if>",

            // 判断职称
            "<if test='positions!=null and positions.length > 0'>",
            "join (\n" +
                    "\tselect distinct usrid\n" +
                    "\tfrom usrposition\n" +
                    "\twhere posid in" +
                    "<foreach collection='positions' item='arr' open='(' separator=',' close=')'>",
                        "#{arr}",
                    "</foreach>",
                ") p on (u.accid=p.usrid)",
            "</if>",

            // 判断职务
            "<if test='dutys!=null and dutys.length > 0'>",
            "join (\n" +
                    "\tselect distinct usrid\n" +
                    "\tfrom usrduty d\n" +
                    "\twhere dutyid in" +
                    "<foreach collection='dutys' item='arr' open='(' separator=',' close=')'>",
                        "#{arr}",
                    "</foreach>",
                    ") t on (u.accid = t.usrid)",
            "</if>",
            "</script>"
    })
    List<UserSelectView> selectUsrSelect(@Param("depid") Integer depid,
                                         @Param("positions") Integer[] positions,
                                         @Param("dutys") Integer[] dutys);

    /**
     * 查询本本部下的所有的成员
     * @param accid
     * @return
     */
    @Select({
            "select \n" +
                    "distinct u.id,\n" +
                    "u.accid,\n" +
                    "u.usrname \n" +
                    "from userinfo u \n" +
                    "join usrdep d on (u.id = d.usrid)\n" +
                    "where d.depid in (\n" +
                    "\tselect d.depid\n" +
                    "\tfrom userinfo u\n" +
                    "\tjoin usrdep d on (u.id = d.usrid)\n" +
                    "\twhere u.accid=#{accid}\n" +
                    ")"
    })
    List<CurDepUsrView> selectCurDepUsr(@Param("accid") String accid);
}