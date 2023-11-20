package com.gzzz.schedule.service.impl;

import com.gzzz.schedule.dao.SysUserDao;
import com.gzzz.schedule.dao.impl.SysUserDaoImpl;
import com.gzzz.schedule.pojo.SysUser;
import com.gzzz.schedule.service.SysUserService;
import com.gzzz.schedule.util.MD5Util;

/**
 * className: SysUserService
 * Package : com.gzzz.schedule.service.impl
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 23:05
 * @Version 1.0
 */
public class SysUserServiceImpl implements SysUserService {
    private SysUserDao userDao = new SysUserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        //将用户的明文密码转化为密文密码
        String userPwd = sysUser.getUserPwd();
        String encrypt = MD5Util.encrypt(userPwd);
        sysUser.setUserPwd(encrypt);

        //调用DAO层方法  将sysUser信息存入数据库
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }
}
