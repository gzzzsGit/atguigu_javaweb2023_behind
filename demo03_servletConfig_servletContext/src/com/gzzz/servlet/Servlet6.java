package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: Servlet6
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/16 15:09
 * @Version 1.0
 */
@WebServlet("/servlet6")
public class Servlet6 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      设置相应行相关的API   HTTP/1.1  200/404/405/500
        resp.setStatus(200);

        String info = "<h1>hello world</h1>";
        //设置响应头相关的API,如果该响应头不在http规范中，也会添加该响应头
//        resp.setHeader("key","value");
//        resp.setHeader("Content-Type","text/html;charset=utf-8");
        //两个很重要的响应头，contentType和Content-Length
        resp.setContentType("text/html;charset=utf-8");
        //响应体中的数据有多长，这里就设置多少
        resp.setContentLength(info.getBytes().length);

        //设置响应体内容API
        //获得一个向响应体中输入文本字符的输出流
        resp.getWriter().write(info);

        // 获得一个向响应体中输入二进制信息的字节输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        outputStream.write(info.getBytes());
    }
}
