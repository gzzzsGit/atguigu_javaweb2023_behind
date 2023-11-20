package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.HttpJspPage;

import java.io.IOException;

/**
 * className: ServletB
 * Package : com.gzzz.servlet
 * Description:
 *      TODO:
 *          Cookie:
 *              会话级Cookie(默认):
 *                  服务器端并没有明确指定Cookie的存在时间
 *                  在浏览器端，Cookie数据存在于内存中
 *                  只要浏览器还开着，Cookie数据就一直都在
 *                  浏览器关闭，内存中的Cookie数据就会被释放
 *              持久化Cookie(设置了setMaxAge())
 *                  服务器端明确设置了Cookie的存在时间
 *                  在浏览器端，Cookie数据会被保存到硬盘上
 *                  Cookie在硬盘上存在的时间根据服务器端限定的时间来管控，不受浏览器关闭的影响
 *                  持久化Cookie到达了预设的时间会被释放
 * @Author gzzz
 * @Create 2023/11/18 23:58
 * @Version 1.0
 */
@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求中携带的cookie
        Cookie[] cookies = req.getCookies();

        //请求中如果没有cookie，数组为null
        if (cookies != null) {
            for (Cookie cookie : cookies
            ) {
                System.out.println(cookie.getName() + "=" + cookie.getValue());
            }
        }

    }
}
