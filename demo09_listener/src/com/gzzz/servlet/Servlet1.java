package com.gzzz.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * className: Servlet1
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/20 22:45
 * @Version 1.0
 */
@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 向应用域中放入数据
        ServletContext application = getServletContext();
        application.setAttribute("keya","valuea");

        // 向session中放入数据
        HttpSession session = req.getSession();
        session.setAttribute("keySession","valuea");

        // 向请求域中放入数据
        req.setAttribute("keyReq","valuea");

        // 请求转发
        req.getRequestDispatcher("servlet4").forward(req,resp);

//        // 手动销毁session
//        session.invalidate();
    }
}
