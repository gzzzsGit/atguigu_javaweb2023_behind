package com.gzzz.schedule.dao.impl;

import com.gzzz.schedule.dao.BaseDao;
import com.gzzz.schedule.dao.SysScheduleDao;
import com.gzzz.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * className: SysScheduleDaoImpl
 * Package : com.gzzz.schedule.dao.impl
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 22:28
 * @Version 1.0
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {
    @Override
    public int addSchedule(SysSchedule sysSchedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        int res = baseUpdate(sql, sysSchedule.getUid(), sysSchedule.getTitle(), sysSchedule.getCompleted());
        return res;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select * from sys_schedule";
        List<SysSchedule> res = baseQuery(SysSchedule.class, sql);
        return res;
    }
}
