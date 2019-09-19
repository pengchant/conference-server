package com.justcs.mapper;

import com.justcs.entity.Account;
import com.justcs.entity.Privilege;
import com.justcs.entity.Role;
import com.justcs.entity.Userinfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    /**
     * 通过工号来查询账户的信息
     * @param wokerid
     * @return
     */
    @Select("select * from account where workerid = #{workerid}")
    Account selectByAccount(String wokerid);

    /**
     * 通过工号查询账户的详细信息
     * @param username
     * @return
     */
    @Select("select * from userinfo where accid=#{username}")
    Userinfo selectByUsername(String username);
    /**
     * 根据用户编号查询用户的所有的角色
     * @param usrid
     * @return
     */
    @Select("select\n" +
            "        r.*\n" +
            "        from account a join userrole u on (a.id = u.accid)\n" +
            "        join role r on (u.roleid = r.id)\n" +
            "        where a.id=#{usrid}")
    List<Role> selectRolesById(int usrid);

    /**
     * 通过用户编号查询用户所有的权限
     * @param usrid
     * @return
     */
    @Select("select\n" +
            "        p.*\n" +
            "        from account a join userrole u on (a.id = u.accid)\n" +
            "            join role r on (u.roleid = r.id)\n" +
            "            join userprivilege t on (r.id = t.roleid)\n" +
            "            join privilege p on (t.priviid = p.id)\n" +
            "        where a.id=#{usrid}")
    List<Privilege> selectPrivBysId(int usrid);
}