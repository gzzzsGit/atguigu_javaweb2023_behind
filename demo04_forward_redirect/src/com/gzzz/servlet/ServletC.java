package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: ServletC
 * Package : com.gzzz.servlet
 * Description:
 *      TODO: tomcat10 默认以UTF-8为响应体的编码字符集
 *            向客户端响应一些文字，浏览器默认会按照操作系统的字符集来进行解析
 *            目前windows中文版默认是GBK，这样就会出现乱码
 * @Author gzzz
 * @Create 2023/11/16 21:48
 * @Version 1.0
 */
@WebServlet("/servletC")
public class ServletC extends HttpServlet {
    //向客户端响应一些文字
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //方式一：设置响应体的编码字符集, 不推荐，客户端解析的字符集无法预测，目前windows中文版默认是GBK，别的不一定
//        resp.setCharacterEncoding("GBK");

        //方式二：告诉客户端使用指定的字符集进行编码， 通过设置Content-Type响应头
        resp.setCharacterEncoding("UTF-8");
        resp.setHeader("Content-Type", "text/html;charset=UTF-8");
        resp.getWriter().write("hello 你好");
    }
}
