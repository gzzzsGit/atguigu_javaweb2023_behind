package com.gzzz.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: ServletA
 * Package : com.gzzz.servlet
 * Description:
 *      TODO:
 *           重定向到servletB
 *               1  相对路径
 *                  与前端的相对路径规则一致
 *               2  绝对路径
 *
 * @Author gzzz
 * @Create 2023/11/16 22:23
 * @Version 1.0
 */
@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA service...");

        /**
         * 请求转发：
         *      相对路径写法与前端的规则一致
         *      绝对路径写法与前端的规则不同：
         *          不需要添加上下文路径
         *
         */
        //相对路径
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");

        //绝对路径
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servletB");
        requestDispatcher.forward(req,resp);

        /**
         * 重定向:
         *    相对路径和绝对规则都与前端相同
         *          绝对路径起始为localhost:8080/
         */
        //相对路径
//        resp.sendRedirect("servletB");
        //绝对路径
//        resp.sendRedirect("/demo05/servletB");
    }
}
