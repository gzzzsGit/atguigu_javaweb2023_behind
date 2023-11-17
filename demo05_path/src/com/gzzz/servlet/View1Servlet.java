package com.gzzz.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: View1Servlet
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/16 22:24
 * @Version 1.0
 */
@WebServlet("/view1Servlet")
public class View1Servlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求转发的基准路径相当于localhost:8080/demo05/
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/views/view1.html");
        requestDispatcher.forward(req, resp);
    }
}
