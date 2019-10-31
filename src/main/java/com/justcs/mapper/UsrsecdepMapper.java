package com.justcs.mapper;

import com.justcs.entity.Usrsecdep;
import com.justcs.view.UserSecDepView;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UsrsecdepMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Usrsecdep record);

    int insertSelective(Usrsecdep record);

    Usrsecdep selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Usrsecdep record);

    int updateByPrimaryKey(Usrsecdep record);

    /**
     * 根据部门编号查询已经选择的用户信息
     * @param secDepid
     * @return
     */
    @Select({
            "SELECT \n" +
                    "d.id as id,\n" +
                    "d.secdepid as secdepid,\n" +
                    "u.usrname as usrname,\n" +
                    "d.usrid as workerid\n" +
                    "FROM `usrsecdep` d\n" +
                    "\t join userinfo u on (d.usrid = u.accid)\n" +
                    "where secdepid=#{secDepid}"
    })
    List<UserSecDepView> querySecDepUsrs(@Param("secDepid") String secDepid);
}