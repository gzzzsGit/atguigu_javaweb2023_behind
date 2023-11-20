package com.gzzz.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.w3c.dom.html.HTMLTableCaptionElement;

import java.io.IOException;

/**
 * className: ServletB
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/19 12:25
 * @Version 1.0
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求域中的数据
        String reqMessage = (String) req.getAttribute("request");
        System.out.println("请求域: "+reqMessage);

        // 获取会话域中的数据
        HttpSession session = req.getSession();
        String sessionMessage = (String) session.getAttribute("session");
        System.out.println("会话域: "+sessionMessage);

        // 获取应用域中的数据
        ServletContext application = getServletContext();
        String applicationMessage = (String) application.getAttribute("application");
        System.out.println("应用域: "+applicationMessage);

    }
}
