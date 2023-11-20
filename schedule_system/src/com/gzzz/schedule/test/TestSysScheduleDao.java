package com.gzzz.schedule.test;

import com.gzzz.schedule.dao.SysScheduleDao;
import com.gzzz.schedule.dao.impl.SysScheduleDaoImpl;
import com.gzzz.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * className: TestSysScheduleDao
 * Package : com.gzzz.schedule.test
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 22:43
 * @Version 1.0
 */
public class TestSysScheduleDao {
    private static SysScheduleDao sysScheduleDao;

    @BeforeClass
    public static void initScheduleDao() {
        sysScheduleDao = new SysScheduleDaoImpl();
    }

    @Test
    public void testAddSchedule(){
        int rows = sysScheduleDao.addSchedule(new SysSchedule(null, 2, "学习数学", 0));
        System.out.println(rows);
    }

    @Test
    public void testFindAll(){
        List<SysSchedule> schedules = sysScheduleDao.findAll();
        schedules.forEach(System.out::println);
    }
}
