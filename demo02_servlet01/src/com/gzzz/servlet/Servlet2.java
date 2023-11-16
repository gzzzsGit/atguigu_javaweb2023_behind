package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: Servlet2
 * Package : com.gzzz.servlet
 * Description:
 *      TODO:
 *           设置WebServlet注解替代设置web.xml，两者冲突只设置一个
 *           Webservlet注解的属性：
 *              name：设置别名，同web.xml里面的servlet-name
 *              value:设置映射路径，同web.xml里面的url-pattern，其中value自己可以省略不写
 *              urlPatterns:设置映射路径，同web.xml里面的url-pattern，value和urlPatterns不能同时设置，设置了一个就会把对方也设置,可设置多个url-pattern
 * @Author gzzz
 * @Create 2023/11/15 1:04
 * @Version 1.0
 */

@WebServlet({"/Servlet02","/Servlet2"})//其实是设置了value
//@WebServlet(name = "Servlet2", value = {"/Servlet2","/Servlet02"})
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet2.service...");
    }
}
