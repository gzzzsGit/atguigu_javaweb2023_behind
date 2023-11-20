package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import listener.MyActivationListener;
import listener.SessionBindingListener;

import java.io.IOException;

/**
 * className: com.gzzz.servlet.ServletPlus
 * Package : PACKAGE_NAME
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/21 1:55
 * @Version 1.0
 */
@WebServlet("/servletP1")
public class ServletPlus1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        SessionBindingListener sb1 = new SessionBindingListener();
        // 当把这个监听器对象放入session域中会触发
        session.setAttribute("sb1",sb1);
        session.removeAttribute("sb1");

        MyActivationListener myActivationListener = new MyActivationListener();
        session.setAttribute("myActivationListener",myActivationListener);

        session.setAttribute("k1","v1");

        // 手动销毁session
//        session.invalidate();
    }
}
