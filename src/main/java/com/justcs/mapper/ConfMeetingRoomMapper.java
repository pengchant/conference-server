package com.justcs.mapper;

import com.justcs.entity.ConfMeetingRoom;
import com.justcs.entity.ConfMeetingRoomKey;
import com.justcs.view.ConfArrangeMentView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ConfMeetingRoomMapper {
    int deleteByPrimaryKey(ConfMeetingRoomKey key);

    int insert(ConfMeetingRoom record);

    int insertSelective(ConfMeetingRoom record);

    ConfMeetingRoom selectByPrimaryKey(ConfMeetingRoomKey key);

    int updateByPrimaryKeySelective(ConfMeetingRoom record);

    int updateByPrimaryKey(ConfMeetingRoom record);


    /**
     * 查询过去三天和未来的会议室安排
     * @param roomid
     * @return
     */
    @Select({
            "<script>",
            "select\n" +
                    "\tc.confname, \n" +
                    "\tm.starttime,\n" +
                    "\tm.endtime\n" +
                    "from confmeetingroom m \n" +
                    "\tjoin conference c on (m.confid = c.id)\n" +
                    "where (datediff(m.starttime, now()) = -3\n" +
                    "\tor datediff(m.starttime, now()) >= 0)",

            // 按照条件查询
            "<if test='roomid!=null'>",
            "and m.meetroomid=#{roomid}",
            "</if>",

            "</script>"
    })
    List<ConfArrangeMentView> selectCofArrange(@Param("roomid") Integer roomid);
}