package com.gzzz.schedule.test;

import com.gzzz.schedule.dao.BaseDao;
import com.gzzz.schedule.pojo.SysSchedule;
import com.gzzz.schedule.pojo.SysUser;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * className: TestBaseDaO
 * Package : com.gzzz.schedule.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 21:49
 * @Version 1.0
 */
public class TestBaseDao {
    private static BaseDao baseDao;

    @BeforeClass
    public static void initBaseDao() {
        baseDao = new BaseDao();
    }

    @Test
    public void testBaseQueryObject() {
        // 查询用户数量
        String sql = "select count(*) from sys_user";
        Long aLong = baseDao.baseQueryObject(Long.class, sql);
        System.out.println(aLong);
    }
    
    @Test
    public void testBaseQuery(){
        // 这里需要使用别名，因为java属性名是驼峰式，数据库中是下划线
        String sql = "select uid,username,user_pwd userPwd from sys_user";
        List<SysUser> res = baseDao.baseQuery(SysUser.class, sql);
        System.out.println(res);
    }
    
    @Test
    public void testBaseUpdate(){
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?) ";
        int rows = baseDao.baseUpdate(sql, 1, "学习JAVA", 0);
        System.out.println(rows);
    }
}
