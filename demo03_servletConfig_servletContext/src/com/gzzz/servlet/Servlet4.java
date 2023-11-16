package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * className: Servlet4
 * Package : com.gzzz.servlet
 * Description:
 *      TODO:
 *          URI 统一资源标识符   interface URI()    资源定义的要求和规范
 *          URL 统一资源定位符   class URL implements URL()    一个具体的资源路径
 * @Author gzzz
 * @Create 2023/11/16 1:09
 * @Version 1.0
 */
@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //行相关 GET.POST uri http/1.1
        System.out.println(req.getMethod());//获取请求方式
        System.out.println(req.getScheme());//获取请求协议
        System.out.println(req.getProtocol());//获取请求协议及版本  http://localhost:8080/demo03/servlet4
        System.out.println(req.getRequestURL());//获取请求的URL  项目内资源的完成的路径 /demo03/servlet4

        System.out.println(req.getLocalPort());//本应用容器的端口号 8080
        System.out.println(req.getRemotePort());//客户端软件的端口号
        System.out.println(req.getServerPort());//客户端发请求使用的端口号，如果设置了代理，则是请求代理服务器的端口号，否则与getLocalPort相同

        //头相关  key:value key:value
        //根据名字获取某个请求头
        String accept = req.getHeader("Accept");
        System.out.println("Accept: "+accept);

        // 获取本次请求中所有请求头
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName+" = "+req.getHeader(headerName));
        }
    }
}
