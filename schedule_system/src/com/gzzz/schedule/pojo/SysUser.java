package com.gzzz.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * className: SysUser
 * Package : com.gzzz.schedule.pojo
 * Description:
 *      TODO:
 *          1 实体类的类名与表格名称应该一一对应（驼峰式对应下划线）
 *          2 实体类的属性名与表格的列名应该一一对应（驼峰式对应下划线）
 *          3 每个属性都必须是私有的
 *          4 每个属性都应该有getter setter方法
 *          5 必须具备无参构造器
 *          6 应该实现序列化接口
 *          7 应该重写类的hashcode 和equals方法
 *          8 toString是否重写都可以
 *
 *      TODO；
 *           可以使用lombok帮助我们生成这些内容
 *           getter and setter 全参构造 无参构造 equals hashcode
 *           步骤:
 *               1 安装lombok插件
 *               2 检查是否勾选了 enable annotation processing
 *               3 导入Lombok依赖
 *               4
 * @Author gzzz
 * @Create 2023/11/17 18:23
 * @Version 1.0
 */
@AllArgsConstructor //添加了全参构造
@NoArgsConstructor //添加了无参构造
@Data // 相当于@Getter @Setter @EqualsAndHashCode @ToString 四个注解
public class SysUser{
    private Integer uid;
    private String username;
    private String userPwd;
}
