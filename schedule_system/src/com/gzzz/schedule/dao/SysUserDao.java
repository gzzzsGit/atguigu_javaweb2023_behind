package com.gzzz.schedule.dao;

import com.gzzz.schedule.pojo.SysUser;

/**
 * className: SysUserDao
 * Package : com.gzzz.schedule.dao
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 19:42
 * @Version 1.0
 */
public interface SysUserDao {
    /**
     * 用于向数据库中增加一条用户记录的方法
     * @param sysUser 要增加的记录的username和user_pwd以SysUser实体类对象形式入参
     * @return 返回影响数据库记录的行数，行数为0表示添加失败,行数大于0说明增加成功
     */
    int addSysUser(SysUser sysUser);

    /**
     * 根据用户名获得完整用户信息的方法
     *  @param username 要查询的用户名
     *  @return 如果找到了，则返回SysUser对象，找不到则返回null
     */
    SysUser findByUsername(String username);
}
