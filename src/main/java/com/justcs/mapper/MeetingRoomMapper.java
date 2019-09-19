package com.justcs.mapper;

import com.justcs.entity.MeetingRoom;
import com.justcs.form.MeetingRoom_c;
import com.justcs.view.MeetingRoomView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MeetingRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MeetingRoom record);

    int insertSelective(MeetingRoom record);

    MeetingRoom selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MeetingRoom record);

    int updateByPrimaryKey(MeetingRoom record);

    @Select({
            "<script>",
            "select m.*, d.departname from meetingroom m left join department d on(m.department=d.id)",
            "where 1 = 1",
            // 1.部门
            "<if test='condtion.departmentid !=null'>",
            "and department=#{condtion.departmentid}",
            "</if>",
            // 2.空调
            "<if test='condtion.kt==true'>",
            "and aircondition=1",
            "</if>",
            // 3.投影仪
            "<if test='condtion.tyy==true'>",
            "and projector=1",
            "</if>",
            // 4.麦克风
            "<if test='condtion.mkf==true'>",
            "and microphone=1",
            "</if>",
            // 5.演讲台
            "<if test='condtion.yjt==true'>",
            "and podium=1",
            "</if>",
            // 6.音响
            "<if test='condtion.yx==true'>",
            "and stereo=1",
            "</if>",
            // 7.照明设备
            "<if test='condtion.zmsb==true'>",
            "and lightequ=1",
            "</if>",
            // 8.容纳人数
            "<if test='condtion.contains!=null'>",
            "and maxcontain>=#{condtion.contains}",
            "</if>",
            // 按照某个字段排序
            "<if test='sortby!=null and sortby!=&apos;&apos; and order !=null and order!=&apos;&apos;'>",
            "order by ${sortby} ${order}",
            "</if>",
            "</script>"
    })
    List<MeetingRoomView> queryAllMeetingRoom(@Param("condtion") MeetingRoom_c condtion, @Param("sortby") String sortby, @Param("order") String order);
}