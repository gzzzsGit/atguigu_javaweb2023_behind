package com.gzzz.schedule.dao.impl;

import com.gzzz.schedule.dao.BaseDao;
import com.gzzz.schedule.dao.SysUserDao;
import com.gzzz.schedule.pojo.SysUser;

import java.util.ArrayList;
import java.util.List;

/**
 * className: SysUserDaoImpl
 * Package : com.gzzz.schedule.dao.impl
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/18 1:19
 * @Version 1.0
 */
public class SysUserDaoImpl extends BaseDao implements SysUserDao {
    @Override
    public int addSysUser(SysUser sysUser) {
        String sql = "insert into sys_user values(DEFAULT,?,?);";

        return baseUpdate(sql, sysUser.getUsername(),sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql= "select uid, username, user_pwd userPwd from sys_user where username = ?";
        List<SysUser> list = baseQuery(SysUser.class, sql, username);
        return list!=null && list.size()>0? list.get(0):null;
    }
}
