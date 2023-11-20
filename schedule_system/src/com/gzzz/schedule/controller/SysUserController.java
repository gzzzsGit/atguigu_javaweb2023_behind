package com.gzzz.schedule.controller;

import com.gzzz.schedule.pojo.SysUser;
import com.gzzz.schedule.service.SysUserService;
import com.gzzz.schedule.service.impl.BaseController;
import com.gzzz.schedule.service.impl.SysUserServiceImpl;
import com.gzzz.schedule.util.MD5Util;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: SysUserController
 * Package : com.gzzz.schedule.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/17 23:14
 * @Version 1.0
 */

/**
 *  增加日程的需求     /shedule/add
 *  删除日程的需求     /schedule/remove
 *  修改日程的需求     /schedule/update
 *  查询日程的需求     /schedule/find
 */
@WebServlet("/user/*")
public class SysUserController extends BaseController {
    private SysUserService userService = new SysUserServiceImpl();
    /**
     *  接收用户注册请求的业务处理方法
     * @param req
     * @param resp
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 1 接收客户端提交的参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        // 2 调用服务层方法，完成注册功能
        // 将参数放入一个SysUser对象中，在调用regist方法时传入
        SysUser sysUser = new SysUser(null, username, userPwd);
        int rows = userService.regist(sysUser);

        // 3 根据注册结果 进行页面跳转
        if (rows == 0) {
            resp.sendRedirect("/registFail.html");
        }
        else
            resp.sendRedirect("/registSuccess.html");
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1 接收用户名和密码
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //2 调用服务层方法，根据用户名查询用户信息
        SysUser loginUser = userService.findByUsername(username);
        // 判断用户名是否有误
        if (null == loginUser) {
            resp.sendRedirect("/loginUsernameError.html");
        }
        //3 判断密码是否匹配
        else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {
            resp.sendRedirect("/loginUserPwdError.html");
        } else {
            //4 跳转到首页
            resp.sendRedirect("/showSchedule.html");
        }


    }
}
