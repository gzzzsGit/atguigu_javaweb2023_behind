package com.gzzz.schedule.dao;

import com.gzzz.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * className: SysScheduleDao
 * Package : com.gzzz.schedule.dao
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 19:44
 * @Version 1.0
 */
public interface SysScheduleDao {
    /**
     * 用于向数据中增加一条日程记录
     * @param sysSchedule 日程数据以SysSchedule实体类对象形式入参0
     * @return 受影响的数据库记录行数，行数为0说明增加失败，大于0说明增加成功
     */
    int addSchedule(SysSchedule sysSchedule);

    /**
     *
     * @return
     */
    List<SysSchedule> findAll();

}
