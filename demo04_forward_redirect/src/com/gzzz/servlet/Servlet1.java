package com.gzzz.servlet;

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
 *          1  重定向是通过HttpServletResponse对象实现的
 *          2  响应重定向是在服务器端提示下的，客户端的行为
 *          3  客户端的地址栏是变换的  客户端至少发送了两次请求  客户端产生了多次请求
 *          4  请求产生了多次 后端就会有多个request对象 此时请求的参数不能继续向下传递(比如get请求url后面的查询参数)
 *          5  目标资源可以是静态资源
 *          6  目标资不能源是WEB-INF下的受保护的资源
 *          7  目标资源可以是外部资源(如重定向到完整的URL)
 *         重点： 如果都能实现 页面跳转 ，优先使用重定向
 * @Author gzzz
 * @Create 2023/11/16 19:23
 * @Version 1.0
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet1 service...");

        // 响应重定向,设置响应码为302，同时设置location响应头
//        resp.sendRedirect("servlet2");

        //相当于如下设置
        //        resp.setHeader("location", "servlet2");
        //        resp.setStatus(302);

        //请求静态资源
//        resp.sendRedirect("a.html");

        //请求WEB-INF下的受保护的资源失败，因为是客户端行为，不是服务器行为
//        resp.sendRedirect("WEB-INF/b.html");

        //请求外部资源
        resp.sendRedirect("http://www.baidu.com");
    }

}
