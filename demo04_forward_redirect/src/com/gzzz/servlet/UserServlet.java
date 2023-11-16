package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

/**
 * className: UserServlet
 * Package : com.gzzz.servlet
 * Description:
 *    TODO:
 *       tomcat10 默认以UTF-8为请求体的解码字符集
 *       客户端提交数据时，要是以其他字符集对请求体中的数据进行编码则会出现乱码
 *       需要设置请求体的解码使用的字符集
 *       get请求可以设置tomcat的conf目录下server.xml文件中 connector内设置URIEncoding
 *
 *
 * @Author gzzz
 * @Create 2023/11/16 20:41
 * @Version 1.0
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先设置请求体的解码字符集
        req.setCharacterEncoding("GBK");
        System.out.println(req.getParameter("username"));
    }
}
