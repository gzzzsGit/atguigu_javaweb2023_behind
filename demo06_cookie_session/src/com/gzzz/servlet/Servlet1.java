package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import javax.swing.*;
import java.io.IOException;

/**
 * className: Servlet1
 * Package : com.gzzz.servlet
 * Description:
 *        TODO:
 *         req.getSession()
 *         // 判断请求中有没有一个特殊的cookie key是JSESSIONID
 *         // 1 有
 *             // 根据JSESSIONID找对应的session对象
 *                 // 1 找到了，返回该session
 *                 // 2 没找到，创建一个新的seesion并返回，并向response对象中存放一个JSESSIONID的cookie
 *         // 2 没有
 *             // 创建一个新的seesion并返回，并向response对象中存放一个JSESSIONID的cookie
 * @Author gzzz
 * @Create 2023/11/19 0:50
 * @Version 1.0
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接受请求中的参数
        String username = req.getParameter("username");


        // 获得session对象
        HttpSession session = req.getSession();
        //session默认存活时间是30分钟，这里设置为60秒
        session.setMaxInactiveInterval(60);

        System.out.println(session.getId());
        System.out.println(session.isNew());

        // 将username存入session
        session.setAttribute("username",username);

        //客户端响应信息
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write("成功");
    }
}
