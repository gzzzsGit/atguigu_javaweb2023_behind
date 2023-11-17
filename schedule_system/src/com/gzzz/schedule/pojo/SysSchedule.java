package com.gzzz.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * className: SysSchedule
 * Package : com.gzzz.schedule.pojo
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 19:34
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule {
    private Integer sid;
    private Integer uid;
    private String title;
    private Integer completed;

}
