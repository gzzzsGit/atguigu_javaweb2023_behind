package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: Servlet1
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/11 0:57
 * @Version 1.0
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Servlet1.service...");
    }
}
