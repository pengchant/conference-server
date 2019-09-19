package com.justcs.mapper;

import com.justcs.entity.Conference;
import com.justcs.entity.ConferenceWithBLOBs;
import com.justcs.view.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConferenceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ConferenceWithBLOBs record);

    int insertSelective(ConferenceWithBLOBs record);

    ConferenceWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ConferenceWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ConferenceWithBLOBs record);

    int updateByPrimaryKey(Conference record);


    /**
     * 查询我的所有的预约（首页展示）
     *
     * @param recorderid
     * @return
     */
    @Select({
            "<script>",
            "select\n" +
                    "c.id as confid,\n" +
                    "c.confname as confname,\n" +
                    "s.id as statusid,\n" +
                    "s.confstatus as confstatus,\n" +
                    "r.starttime as starttime,\n" +
                    "r.endtime as endtime\n" +
                    "from conference c \n" +
                    "\tjoin confmeetingroom r on (c.id = r.confid)\n" +
                    "\tjoin confstatus s on (c.confstatusid = s.id)",
            "where r.endtime >= now()",
            "<if test='recorderid!=null and recorderid!=&apos;&apos;'>",
            "and c.recorderid=#{recorderid}",
            "</if>",
            "order by r.starttime asc",
            "</script>"
    })
    List<MyOrderView> selectAllMyOrders(@Param("recorderid") String recorderid);


    /**
     * 查询即将开始的会议（首页展示）
     *
     * @param workerid
     * @return
     */
    @Select({
            "<script>",
            "select\n" +
                    "q.confid,\n" +
                    "q.confname,\n" +
                    "q.starttime,\n" +
                    "q.endtime,\n" +
                    "q.confstatusid as statusid,\n" +
                    "q.confstatus as confstatus\n" +
                    "from (\n" +
                    "\tSELECT id as attid,\n" +
                    "\tworkerid,\n" +
                    "\tconfid\n" +
                    "\tFROM\n" +
                    "\t\tattendes \n" +
                    "\tWHERE\n" +
                    "\t\t1=1",
            "<if test='workerid!=null and workerid!=&apos;&apos;'>",
            "and workerid=#{workerid}",
            "</if>",
            ") p join (\n" +
                    "\tselect c.id as confid,\n" +
                    "\t\tc.confname,\n" +
                    "\t\tr.starttime,\n" +
                    "\t\tr.endtime,\n" +
                    "\t\tc.confstatusid,\n" +
                    "\t\ts.confstatus\n" +
                    "\tfrom conference c\n" +
                    "\t\tjoin confmeetingroom r on (c.id = r.confid)\n" +
                    "\t\tjoin confstatus s on (c.confstatusid= s.id)\n" +
                    "\twhere\n" +
                    "\t\tr.starttime > now()\n" +
                    ") q on (q.confid = p.confid)\n" +
                    "order by q.starttime asc",
            "</script>"
    })
    List<MyOrderView> selectAllCommingOrders(@Param("workerid") String workerid);


    /**
     * 查询会议的所有信息
     */
    @Select({
            "<script>",
            "select \n" +
                    "c.id as confid,\n" +
                    "c.confname as confname,\n" +
                    "s.semestername,\n" +
                    "l.levelname,\n" +
                    "c.hosterid,\n" +
                    "u.usrname as hoster,\n" +
                    "c.recorderid,\n" +
                    "c.recorder,\n" +
                    "p.starttime,\n" +
                    "p.endtime,\n" +
                    "r.id as roomid,\n" +
                    "r.roomname,\n" +
                    "c.conclusion\n" +
                    "from conference c \n" +
                    "\tjoin semester s on (c.semesterid = s.id)\n" +
                    "\tjoin conflevel l on (c.conflevelid = l.id)\n" +
                    "\tjoin confmeetingroom p on (c.id = p.confid)\n" +
                    "\tjoin meetingroom r on (p.meetroomid = r.id)",
            "\tleft join userinfo u on (c.hosterid = u.id)",
            "where 1=1",
            "<if test='confid!=null and confid!=&apos;&apos;'>",
            "and c.id=#{confid}",
            "</if>",
            "</script>"
    })
    BasicConfInfoView selectbasicconf(@Param("confid") String confid);


    /**
     * 查询会议的列席人员
     *
     * @param confid
     * @return
     */
    @Select({
            "<script>",
            "select\n" +
                    "a.workerid,\n" +
                    "u.usrname,\n" +
                    "a.hasattend\n" +
                    "from conference c\n" +
                    "\tjoin attendes a on (c.id = a.confid)\n" +
                    "\tjoin userinfo u on (a.workerid = u.accid)",
            "where 1=1",
            "<if test='confid!=null and confid!=&apos;&apos;'>",
            "and c.id=#{confid}",
            "</if>",
            "</script>"
    })
    List<ListAttendersView> selectAttendsList(@Param("confid") String confid);

    /**
     * 查询会议的属性
     *
     * @param confid
     * @return
     */
    @Select({
            "<script>",
            "select\n" +
                    "c.id as confid,\n" +
                    "t.attrname,\n" +
                    "t.attrdes\n" +
                    "from conference c \n" +
                    "\tjoin confattr a on (c.id = a.confid)\n" +
                    "\tjoin confattributes t on (a.confattrid = t.id)",
            "where 1=1",
            "<if test='confid!=null and confid!=&apos;&apos;'>",
            "and c.id=#{confid}",
            "</if>",
            "</script>"
    })
    List<ConfAttributesListView> selectConfAttrList(@Param("confid") String confid);


    /**
     * 查询会议议题采集表基本信息
     *
     * @param confid
     * @return
     */
    @Select({
            "<script>",
            "select \n" +
                    "u.usrname as collegeleader,\n" +
                    "m.id as collectid,\n" +
                    "c.id as confid,\n" +
                    "m.colltime,\n" +
                    "m.termyear,\n" +
                    "m.meetweeks \n" +
                    "from meetingcollect m \n" +
                    "\tjoin conference c on (m.id = c.meetcollectid)",
                    "\tleft join userinfo u on (u.accid = m.collegeleader)" +
            "where 1=1",
            "<if test='confid!=null and confid!=&apos;&apos;'>",
            "and c.id=#{confid}",
            "</if>",
            "</script>"
    })
    ConfCollectBasicInfoView selectCollectView(@Param("confid") String confid);


    /**
     * 查询上次会议所提议题
     *
     * @param confid
     * @return
     */
    @Select({
            "<script>",
            "select \n" +
                    "a.collectid,\n" +
                    "l.id as issuelastid,\n" +
                    "l.maincontent\n" +
                    "from (\n" +
                    "\tselect  \n" +
                    "\t\tm.id as collectid,\n" +
                    "\t\tc.id as confid \n" +
                    "\tfrom meetingcollect m \n" +
                    "\t\tjoin conference c on (m.id = c.meetcollectid)",
            "where 1=1",
            "<if test='confid!=null and confid!=&apos;&apos;'>",
            "and c.id=#{confid}",
            "</if>",
            ") a join issuelastmeet l on (a.collectid = l.meetcollid)",
            "</script>"
    })
    List<ConfLastIssueView> selectLastIssueList(@Param("confid") String confid);


    /**
     * 查询本次会议需要解决的议题
     *
     * @param confid
     * @return
     */
    @Select({
            "<script>",
            "select \n" +
                    "a.collectid,\n" +
                    "l.id as issuecurrent,\n" +
                    "l.mainconent\n" +
                    "from (\n" +
                    "\tselect  \n" +
                    "\t\tm.id as collectid,\n" +
                    "\t\tc.id as confid \n" +
                    "\tfrom meetingcollect m \n" +
                    "\t\tjoin conference c on (m.id = c.meetcollectid)",
            "where 1=1",
            "<if test='confid!=null and confid!=&apos;&apos;'>",
            "and c.id=#{confid}",
            "</if>",
            ") a join issuecurmeet l on (a.collectid = l.meetcollid)",
            "</script>"
    })
    List<ConfCurIssueView> selectCurIssueList(@Param("confid") String confid);


    /**
     * 查询建议解决的方案
     *
     * @param confid
     * @return
     */
    @Select({
            "<script>",
            "select \n" +
                    "a.collectid,\n" +
                    "l.id as issuecurrent,\n" +
                    "l.maincontent\n" +
                    "from (\n" +
                    "\tselect  \n" +
                    "\t\tm.id as collectid,\n" +
                    "\t\tc.id as confid \n" +
                    "\tfrom meetingcollect m \n" +
                    "\t\tjoin conference c on (m.id = c.meetcollectid)",
            "where 1=1",
            "<if test='confid!=null and confid!=&apos;&apos;'>",
            "and c.id=#{confid}",
            "</if>",
            ") a join suggestion l on (a.collectid = l.meetcollid)",
            "</script>"
    })
    List<ConfSuggestionView> selectSuggesList(@Param("confid") String confid);


    /**
     * 查询会议记录内容以及录音列表内容
     *
     * @param confid
     * @return
     */
    @Select({
            "select \n" +
                    "\tt.titleid as titleid,\n" +
                    "\tr.id as recordid,\n" +
                    "\tv.id as voiceid,\n" +
                    "\tt.titlename as titlename,\n" +
                    "\tr.speakerid as speakerid,\n" +
                    "\tr.speakername as speakername,\n" +
                    "\tr.speaking as speaking,\n" +
                    "\tv.voiceurl\n" +
                    "from (\n" +
                    "\tselect \n" +
                    "\t\tid as titleid,\n" +
                    "\t\tconftitlecnt as titlename\n" +
                    "\tfrom conftitle t \n" +
                    "\twhere t.confid = #{confid}\n" +
                    ") t left join conftitlerecord r  on (r.conftitleid = t.titleid)\n" +
                    "left join voicerecord v on (r.id = v.conftitlerecordid)\n" +
                    "order by t.titleid,r.speaktime desc"
    })
    List<ConfRecVoicDetailView> selectConfRecVoic(@Param("confid") String confid);


    /**
     * 查询已经预定的会议
     *
     * @param workerid
     * @return
     */
    @Select({
            "<script>",
            "select \n" +
                    "c.id as conferenceid,\n" +
                    "c.confname as confname,\n" +
                    "s.id as semesterid,\n" +
                    "s.semestername as semester,\n" +
                    "l.id as levelid,\n" +
                    "l.leveldes as levelname,\n" +
                    "c.recorderid as recorderid,\n" +
                    "c.recorder as recorder,\n" +
                    "e.colltime as colltime,\n" +
                    "t.id as statusid,\n" +
                    "t.confstatus as confstatus,\n" +
                    "c.meetcollectid as meetcollectid\n" +
                    "from conference c \n" +
                    "left join semester s on (c.semesterid=s.id)\n" +
                    "left join conflevel l on (c.conflevelid = l.id)\n" +
                    "left join meetingcollect e on (c.meetcollectid = e.id)\n" +
                    "left join confstatus t on (c.confstatusid = t.id)\n" +
                    "where 1=1 \n",
            // 会议的状态
            "<choose>",
            "<when test='statusid !=null and statusid!=&apos;&apos;'>",
            "and c.confstatusid=#{statusid}",
            "</when>",
            "<otherwise>",
            "and (c.confstatusid='1' or c.confstatusid='2' or c.confstatusid='101')",
            "</otherwise>",
            "</choose>",
            // 申请人员
            "<if test='workerid !=null and workerid!=&apos;&apos;'>",
            "and c.recorderid=#{workerid}",
            "</if>",
            // 会议名称
            "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and c.confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and e.colltime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and e.colltime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"starttime!=null and starttime!='' and endtime !=null and endtime!=''\">\n" +
                    "            and e.colltime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",
            // 按照某个字段排序
            "<choose>",
            "<when test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</when>",
            "<otherwise>",
            "order by e.colltime desc",
            "</otherwise>",
            "</choose>",
            "</script>"
    })
    List<OrderConfView> selectOrderdConfView(
            @Param("workerid") String workerid
            , @Param("statusid") String statusid
            , @Param("confname") String confname
            , @Param("starttime") String start
            , @Param("endtime") String end
            , @Param("sortby") String sortby
            , @Param("order") String order);


    /**
     * 查询本部门待审核的会议
     *
     * @param workerid
     * @return
     */
    @Select({
            "<script>",
            "SELECT\n" +
                    "\to.* \n" +
                    "FROM\n" +
                    "\t(\n" +
                    "\t\t\tSELECT\n" +
                    "\t\t\t\tc.id AS conferenceid,\n" +
                    "\t\t\t\tc.confname AS confname,\n" +
                    "\t\t\t\ts.id AS semesterid,\n" +
                    "\t\t\t\ts.semestername AS semester,\n" +
                    "\t\t\t\tl.id AS levelid,\n" +
                    "\t\t\t\tl.leveldes AS levelname,\n" +
                    "\t\t\t\tc.recorderid AS recorderid,\n" +
                    "\t\t\t\tc.recorder AS recorder,\n" +
                    "\t\t\t\te.colltime AS colltime,\n" +
                    "\t\t\t\tt.id AS statusid,\n" +
                    "\t\t\t\tt.confstatus AS confstatus,\n" +
                    "\t\t\t\tc.meetcollectid AS meetcollectid,\n" +
                    "\t\t\t  c.hosterid,\n" +
                    "\t\t\t  c.hoster\t\n" +
                    "\t\t\tFROM\n" +
                    "\t\t\t\tconference c\n" +
                    "\t\t\t\t\tLEFT JOIN semester s ON ( c.semesterid = s.id )\n" +
                    "\t\t\t\t\tLEFT JOIN conflevel l ON ( c.conflevelid = l.id )\n" +
                    "\t\t\t\t\tLEFT JOIN meetingcollect e ON ( c.meetcollectid = e.id )\n" +
                    "\t\t\t\t\tLEFT JOIN confstatus t ON ( c.confstatusid = t.id ) \n" +
                    "\t\t\tWHERE\n" +
                    "\t\t\t\tt.id = '1' and c.hosterid=#{workerid}\n" +
                    "\t) o ",
            "where 1=1 ",
            // 会议名称
            "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and o.confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and o.colltime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and o.colltime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"(starttime!=null and starttime!='') and (endtime !=null and endtime!='')\">\n" +
                    "            and o.colltime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",
            // 按照某个字段排序
            "<choose>",
            "<when test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</when>",
            "<otherwise>",
            "order by o.colltime desc",
            "</otherwise>",
            "</choose>",
            "</script>"
    })
    List<OrderConfView> selectValidatingView(
            @Param("workerid") String workerid
            , @Param("confname") String confname
            , @Param("starttime") String start
            , @Param("endtime") String end
            , @Param("sortby") String sortby
            , @Param("order") String order);


    /**
     * 查询待审核会议材料(查询已经提交的)
     *
     * @param workerid
     * @param confname
     * @param start
     * @param end
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            // 查询预约会议
            "select " +
                    "c.id as conferenceid,\n" +
                    "c.confname as confname,\n" +
                    "s.id as semesterid,\n" +
                    "s.semestername as semester,\n" +
                    "l.id as levelid,\n" +
                    "l.leveldes as levelname,\n" +
                    "c.recorderid as recorderid,\n" +
                    "c.recorder as recorder,\n" +
                    "e.colltime as colltime,\n" +
                    "t.id as statusid,\n" +
                    "t.confstatus as confstatus,\n" +
                    "c.meetcollectid as meetcollectid\n" +
                    "from conference c \n" +
                    "left join semester s on (c.semesterid=s.id)\n" +
                    "left join conflevel l on (c.conflevelid = l.id)\n" +
                    "left join meetingcollect e on (c.meetcollectid = e.id)\n" +
                    "left join confstatus t on (c.confstatusid = t.id)\n" +
                    "where c.recorderid=#{workerid}\n" +
                    "and c.confstatusid='4' \n" +
                    // 会议名称
                    "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and e.colltime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and e.colltime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"(starttime!=null and starttime!='') and (endtime !=null and endtime!='')\">\n" +
                    "            and e.colltime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",

            // 查询直接开会会议
            " union " +
                    "select \n" +
                    "d.id as conferenceid,\n" +
                    "d.confname as confname,\n" +
                    "s.id as semesterid,\n" +
                    "s.semestername as semester,\n" +
                    "d.conftypeid as levelid,\n" +
                    "l.levelname as levelname,\n" +
                    "d.recorderid as recorderid,\n" +
                    "u.usrname as recorder," +
                    "d.subtime as colltime,\n" +
                    "d.confstatus as statusid,\n" +
                    "t.confstatus as confstatus,\n" +
                    " '0' as meetcollectid\n" +
                    "from directconf d \n" +
                    "\tleft join conflevel l on(l.id = d.conftypeid)\n" +
                    "\tleft join userinfo u on (u.accid = d.recorderid)\n" +
                    "\tleft join semester s on(s.id = d.semesterid)\n" +
                    "\tleft join confstatus t on(t.id = d.confstatus)\n" +
                    "where d.recorderid = #{workerid}\n" +
                    "\tand d.confstatus = '4' " +
                    // 会议名称
                    "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and d.subtime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and d.subtime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"(starttime!=null and starttime!='') and (endtime !=null and endtime!='')\">\n" +
                    "            and d.subtime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",


            // 按照某个字段排序
            "<choose>",
            "<when test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</when>",
            "<otherwise>",
            "order by colltime desc",
            "</otherwise>",
            "</choose>",
            "</script>"
    })
    List<OrderConfView> selectConfRecordValidating(
            @Param("workerid") String workerid
            , @Param("confname") String confname
            , @Param("starttime") String start
            , @Param("endtime") String end
            , @Param("sortby") String sortby
            , @Param("order") String order
    );


    /**
     * 查询待审核会议材料（查询我需要审核的）
     *
     * @param workerid
     * @param confname
     * @param start
     * @param end
     * @param sortby
     * @param order
     * @return
     */
    @Select({
            "<script>",
            // 查询预约会议
            "select " +
                    "c.id as conferenceid,\n" +
                    "c.confname as confname,\n" +
                    "s.id as semesterid,\n" +
                    "s.semestername as semester,\n" +
                    "l.id as levelid,\n" +
                    "l.leveldes as levelname,\n" +
                    "c.recorderid as recorderid,\n" +
                    "c.recorder as recorder,\n" +
                    "e.colltime as colltime,\n" +
                    "t.id as statusid,\n" +
                    "t.confstatus as confstatus,\n" +
                    "c.meetcollectid as meetcollectid\n" +
                    "from conference c \n" +
                    "left join semester s on (c.semesterid=s.id)\n" +
                    "left join conflevel l on (c.conflevelid = l.id)\n" +
                    "left join meetingcollect e on (c.meetcollectid = e.id)\n" +
                    "left join confstatus t on (c.confstatusid = t.id)\n" +
                    "where c.hosterid=#{workerid}\n" +
                    "and c.confstatusid='4' \n" +
                    // 会议名称
                    "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and e.colltime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and e.colltime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"(starttime!=null and starttime!='') and (endtime !=null and endtime!='')\">\n" +
                    "            and e.colltime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",

            // 查询直接开会会议
            " union " +
                    "select \n" +
                    "d.id as conferenceid,\n" +
                    "d.confname as confname,\n" +
                    "s.id as semesterid,\n" +
                    "s.semestername as semester,\n" +
                    "d.conftypeid as levelid,\n" +
                    "l.levelname as levelname,\n" +
                    "d.recorderid as recorderid,\n" +
                    "u.usrname as recorder," +
                    "d.subtime as colltime,\n" +
                    "d.confstatus as statusid,\n" +
                    "t.confstatus as confstatus,\n" +
                    " '0' as meetcollectid\n" +
                    "from directconf d \n" +
                    "\tleft join conflevel l on(l.id = d.conftypeid)\n" +
                    "\tleft join userinfo u on (u.accid = d.recorderid)\n" +
                    "\tleft join semester s on(s.id = d.semesterid)\n" +
                    "\tleft join confstatus t on(t.id = d.confstatus)\n" +
                    "where d.hosterid = #{workerid}\n" +
                    "\tand d.confstatus = '4' " +
                    // 会议名称
                    "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and d.subtime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and d.subtime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"(starttime!=null and starttime!='') and (endtime !=null and endtime!='')\">\n" +
                    "            and d.subtime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",


            // 按照某个字段排序
            "<choose>",
            "<when test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</when>",
            "<otherwise>",
            "order by colltime desc",
            "</otherwise>",
            "</choose>",
            "</script>"
    })
    List<OrderConfView> selectMyConfRecordValidating(
            @Param("workerid") String workerid
            , @Param("confname") String confname
            , @Param("starttime") String start
            , @Param("endtime") String end
            , @Param("sortby") String sortby
            , @Param("order") String order
    );



    /**
     * 查询通过的会议材料
     *
     * @return
     */
    @Select({
            "<script>",
            // 查询预约会议
            "select " +
                    "c.id as conferenceid,\n" +
                    "c.confname as confname,\n" +
                    "s.id as semesterid,\n" +
                    "s.semestername as semester,\n" +
                    "l.id as levelid,\n" +
                    "l.leveldes as levelname,\n" +
                    "c.recorderid as recorderid,\n" +
                    "c.recorder as recorder,\n" +
                    "e.colltime as colltime,\n" +
                    "t.id as statusid,\n" +
                    "t.confstatus as confstatus,\n" +
                    "c.meetcollectid as meetcollectid\n" +
                    "from conference c \n" +
                    "left join semester s on (c.semesterid=s.id)\n" +
                    "left join conflevel l on (c.conflevelid = l.id)\n" +
                    "left join meetingcollect e on (c.meetcollectid = e.id)\n" +
                    "left join confstatus t on (c.confstatusid = t.id)\n" +
                    "where c.hosterid=#{workerid}\n" +
                    "and c.confstatusid='5' \n" +
                    // 会议名称
                    "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and e.colltime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and e.colltime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"(starttime!=null and starttime!='') and (endtime !=null and endtime!='')\">\n" +
                    "            and e.colltime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",

            // 查询直接开会会议
            " union " +
                    "select \n" +
                    "d.id as conferenceid,\n" +
                    "d.confname as confname,\n" +
                    "s.id as semesterid,\n" +
                    "s.semestername as semester,\n" +
                    "d.conftypeid as levelid,\n" +
                    "l.levelname as levelname,\n" +
                    "d.recorderid as recorderid,\n" +
                    "u.usrname as recorder," +
                    "d.subtime as colltime,\n" +
                    "d.confstatus as statusid,\n" +
                    "t.confstatus as confstatus,\n" +
                    " '0' as meetcollectid\n" +
                    "from directconf d \n" +
                    "\tleft join conflevel l on(l.id = d.conftypeid)\n" +
                    "\tleft join userinfo u on (u.accid = d.recorderid)\n" +
                    "\tleft join semester s on(s.id = d.semesterid)\n" +
                    "\tleft join confstatus t on(t.id = d.confstatus)\n" +
                    "where d.hosterid = #{workerid}\n" +
                    "\tand d.confstatus = '5' " +
                    // 会议名称
                    "<if test='confname !=null and confname!=&apos;&apos;'>",
            "and confname like CONCAT(CONCAT('%', #{confname}), '%')",
            "</if>",
            // 开始和结束时间
            "<if test=\"(starttime!=null and starttime!='') and (endtime==null or endtime=='')\">\n" +
                    "            and d.subtime &gt;= concat(#{starttime}, ' 00:00:00')\n" +
                    "        </if>",
            "<if test=\"(starttime==null or starttime=='') and (endtime!=null and endtime!='')\">\n" +
                    "            and d.subtime &lt;= concat(#{endtime}, ' 23:59:59')\n" +
                    "        </if>",
            "<if test=\"(starttime!=null and starttime!='') and (endtime !=null and endtime!='')\">\n" +
                    "            and d.subtime between concat(#{starttime},' 00:00:00')\n" +
                    "            and\n" +
                    "            concat(#{endtime},' 23:59:59')\n" +
                    "        </if>",


            // 按照某个字段排序
            "<choose>",
            "<when test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</when>",
            "<otherwise>",
            "order by colltime desc",
            "</otherwise>",
            "</choose>",
            "</script>"
    })
    List<OrderConfView> selectConfRecordPassed(
            @Param("workerid") String workerid
            , @Param("confname") String confname
            , @Param("starttime") String start
            , @Param("endtime") String end
            , @Param("sortby") String sortby
            , @Param("order") String order
    );

}