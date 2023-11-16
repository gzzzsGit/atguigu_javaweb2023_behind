package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.security.Provider;

/**
 * className: Servlet2
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/16 19:23
 * @Version 1.0
 */
@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet2 service...");
    }
}
