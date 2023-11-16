package com.gzzz.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.management.ValueExp;
import java.io.IOException;
import java.util.Enumeration;

/**
 * className: Servlet2
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/15 21:35
 * @Version 1.0
 */

@WebServlet(value = "/servlet2",initParams = { @WebInitParam(name = "key2a", value = "value2a"), @WebInitParam(name = "key2b", value = "value2b")})
public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String value1 = config.getInitParameter("key2a");
        System.out.println(value1);
        String value2 = config.getInitParameter("key2b");
        System.out.println(value2);

        Enumeration<String> initParameterNames = config.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println(pname+" = "+config.getInitParameter(pname));
        }

        // ServletContext 获取参数,单例，多个servlet共享
        System.out.println("ServletContext 获取参数........");
        //三种方式对应同一个ServletContext0
        ServletContext servletContext1 = config.getServletContext();
        ServletContext servletContext2 = getServletContext();
        ServletContext servletContext3 = req.getServletContext();
        System.out.println(servletContext1==servletContext2 && servletContext2==servletContext3);//true

        String encodingValue = servletContext1.getInitParameter("encoding");
        System.out.println("encoding: "+encodingValue);

        Enumeration<String> parameterNames = servletContext1.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = servletContext1.getInitParameter(name);
            System.out.println(name+" = "+value);
        }

        //从域对象中读取数据
        //       Object getAttribute(String key);获得域中的数据
        String value = (String) servletContext1.getAttribute("ka");
        System.out.println(value);


    }
}
