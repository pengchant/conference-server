package com.justcs.mapper;

import com.justcs.entity.ConfAttributes;
import com.justcs.entity.DirectConf;
import com.justcs.entity.DirectConfWithBLOBs;
import com.justcs.entity.Userinfo;
import com.justcs.view.DirectConfDetailView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface DirectConfMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DirectConfWithBLOBs record);

    int insertSelective(DirectConfWithBLOBs record);

    DirectConfWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DirectConfWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(DirectConfWithBLOBs record);

    int updateByPrimaryKey(DirectConf record);

    /**
     * 查询会议详细内容
     *
     * @param confid
     * @return
     */
    @Select({
            "select\n" +
                    "d.id as confid,\n" +
                    "d.confname as confname,"+
                    "s.semestername as semester,\n" +
                    "d.confattrs,\n" +
                    "t.levelname as conftype,\n" +
                    "u.usrname as hoster,\n" +
                    "u2.usrname as recorder,\n" +
                    "d.confaddress,\n" +
                    "d.confstarttime as starttime,\n" +
                    "d.confendtime as endtime,\n" +
                    "d.attenders,\n" +
                    "d.maincontent as conftext,\n" +
                    "d.conclusion as conclusion\n" +
                    "from directconf d\n" +
                    "\tleft join semester s on (d.semesterid = s.id)\n" +
                    "  left join conflevel t on (d.conftypeid = t.id)\n" +
                    "\tleft join userinfo u on (u.accid = d.hosterid)\n" +
                    "\tleft join userinfo u2 on (u2.accid = d.recorderid)\n" +
                    "where d.id =#{confid}"
    })
    DirectConfDetailView selectDirectConf(@Param(value = "confid") String confid);

    /**
     * 查询会议属性
     */
    @Select({
            "<script>",
            "select *\n" +
                    "from confattributes a\n" +
                    "where  1=1 ",
                    "<if test='confattrs!=null'>",
                        " and id in ",
                        "<foreach collection='confattrs' index='index' item='item' separator=',' open='(' close=')' >",
                            " #{item} ",
                        "</foreach>",
                    "</if>",
            "</script>"
    })
    List<ConfAttributes> selectConfAttrs(@Param(value = "confattrs") String[] confattrs);


    /**
     * 查询所有参会人员
     * @param users
     * @return
     */
    @Select({
            "<script>",
            "select *\n" +
                    "from userinfo\n" +
                    "where  1=1 ",
            "<if test='usrs!=null'>",
            " and accid in ",
                "<foreach collection='usrs' index='index' item='item' separator=',' open='(' close=')' >",
                    " #{item} ",
                "</foreach>",
            "</if>",
            "</script>"
    })
    List<Userinfo> selectUserinfos(@Param(value = "usrs") String[] users);


}