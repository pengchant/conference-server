package com.justcs.mapper;

import com.justcs.entity.Userinfo;
import com.justcs.form.UserSelectView;
import com.justcs.view.CurDepUsrView;
import com.justcs.view.UsrInfoView;
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
     *
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


    /**
     * 查询系统中用户的视图
     *
     * @param depname
     * @return
     */
    @Select({
            "<script>",
            "select * from (",
            "select\n" +
                    "a.id as accid,\n" +
                    "u.id as usrid,\n" +
                    "a.workerid,\n" +
                    "u.usrname,\n" +
                    "a.email,\n" +
                    "a.phonenum,\n" +
                    "( select \n" +
                    "  group_concat(concat(concat(d.id,'#'), d.departname)) as deptname\n" +
                    "\tfrom usrdep r \n" +
                    "\t\tjoin department d on (r.depid = d.id)\n" +
                    "  where r.usrid = u.id\n" +
                    "\tgroup by r.usrid \n" +
                    ") as departments, \n" +
                    "(\n" +
                    "\tselect\n" +
                    "\tgroup_concat(concat(concat(l.id,'#'), l.rolename)) as rolename\n" +
                    "\tfrom userrole e\n" +
                    "\t\tjoin role l on(e.roleid = l.id)\n" +
                    "\twhere e.accid = a.id\n" +
                    "\tgroup by  e.accid\n" +
                    ") as roles, \n" +
                    "(\n" +
                    "\tselect\n" +
                    "\tgroup_concat(concat(concat(m.id,'#'), m.position)) as positionname\n" +
                    "\tfrom usrposition p\n" +
                    "\t\tjoin mposition m on(p.posid = m.id)\n" +
                    "\twhere p.usrid = u.id\n" +
                    "\tgroup by p.usrid\n" +
                    ") as positions, \n" +
                    "(\n" +
                    "\tselect\n" +
                    "\tgroup_concat(concat(concat(d.id,'#'), d.duty)) as dutyname\n" +
                    "\tfrom usrduty y\n" +
                    "\t\tjoin duty d on(y.dutyid = d.id)\n" +
                    "\twhere y.usrid = u.id\n" +
                    "\tgroup by y.usrid\n" +
                    ") as dutys \n" +
                    "from account a \n" +
                    "\tjoin userinfo u on(a.id = u.accid) ",

            ") mtep",
            " where 1=1 ",

            // 判断用户姓名
            "<if test='usrname !=null and usrname!=&apos;&apos;'>",
            " and usrname like CONCAT(CONCAT('%', #{usrname}), '%')",
            "</if>",

            // 判断部门
            "<if test='depname !=null and depname!=&apos;&apos;'>",
            " and departments like CONCAT(CONCAT('%', #{depname}), '%')",
            "</if>",

            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            " order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<UsrInfoView> selectUsrInfoView(
            @Param("depname") String depname,
            @Param("usrname") String usrname,
            @Param("sortby") String sortby,
            @Param("order") String order
    );


}