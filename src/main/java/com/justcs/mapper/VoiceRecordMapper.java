package com.justcs.mapper;

import com.justcs.entity.VoiceRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VoiceRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VoiceRecord record);

    int insertSelective(VoiceRecord record);

    VoiceRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VoiceRecord record);

    int updateByPrimaryKey(VoiceRecord record);


    /**
     * 查询某会议议题发言的所有录音
     * @param speachid
     * @return
     */
    @Select({
            "select \n" +
                    "* \n" +
                    "from voicerecord where conftitlerecordid=#{speachid}"
    })
    List<VoiceRecord> queryAllVoice(@Param(value = "speachid") String speachid);
}