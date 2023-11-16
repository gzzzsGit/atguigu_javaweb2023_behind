package com.gzzz.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: Servlet1
 * Package : com.gzzz.servlet
 * Description:
 *      TODO:
 *         1  请求转发是通过HttpServletRequest对象实现的
 *         2  请求转发是服务器内部行为，对客户端是屏蔽的
 *         3  客户端只产生了一次请求  服务端只产生了一对 request 和 response对象
 *         4  客户端的地址栏是不变的
 *         5  请求的参数是可以继续向下传递的
 *         6  目标资源可以是servlet动态资源  也可以是html静态资源
 *         7  目标资源可以是WEB-INF下的受保护的资源  该方式也是WEB-INF下的资源的唯一访问方式
 *         8  目标资源不可以是外部的资源
 * @Author gzzz
 * @Create 2023/11/16 15:55
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA service...");

        // 获得请求转发器
        // 请求动态资源
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
        //请求静态资源
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
        //请求WEB-INF下的受保护的资源
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");

        // 请求外部资源失败，因为请求转发是在项目内部，demo04下找资源，即使是完整的URL也无法找到
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.baidu.com");
        // 请求转发器做出转发动作
        requestDispatcher.forward(req, resp);
    }
}
