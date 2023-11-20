package com.gzzz.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * className: ServletA
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/19 11:44
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向请求域存放数据
        req.setAttribute("request","requestMessage");

        // 向会话域存放数据
        HttpSession session = req.getSession();
        session.setAttribute("session","sessionMessage");

        // 向应用域存放数据
        ServletContext application = getServletContext();
        application.setAttribute("application","applicationMessage");

        // 获取请求域数据
        String requestMessage = (String) req.getAttribute("request");
        System.out.println("requestMessage=" + requestMessage);

        // 请求转发
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
//        requestDispatcher.forward(req,resp);

    }
}
