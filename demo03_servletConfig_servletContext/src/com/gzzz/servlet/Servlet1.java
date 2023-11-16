package com.gzzz.servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

/**
 * className: Servlet1
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/15 21:05
 * @Version 1.0
 */
public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // ServletConfig 获取参数
        System.out.println("ServletConfig 获取参数.............");
        ServletConfig servletConfig = this.getServletConfig();
        // 获取初始配置信息
        // 根据参数名获取参数值
        String value1 = servletConfig.getInitParameter("keya");
        System.out.println(value1);
        String value2 = servletConfig.getInitParameter("keyb");
        System.out.println(value2);

        // 获取所有的初始参数名字
        // Enumeration->早期的iteration
        // hasMoreElements  判断有没有下一个元素  如果有返回true，如果没有返回false
        // nextElement  获取下一个元素, 向下移动游标
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println(pname+" = "+servletConfig.getInitParameter(pname));
        }

        // ServletContext 获取参数,单例，多个servlet共享
        System.out.println("ServletContext 获取参数........");

        // 编程习惯，应用域对象常被赋值为application
        ServletContext application  = servletConfig.getServletContext();
        //三种方式对应同一个ServletContext
        ServletContext servletContext1 = servletConfig.getServletContext();
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

        //域对象的三个API
//       void setAttribute(String key,Object value);向域中存储/修改数据
        servletContext1.setAttribute("ka", "va");
//        向域中修改数据
//        servletContext1.setAttribute("ka", "vaa");
////       Object getAttribute(String key);获得域中的数据
//        String value = (String) servletContext1.getAttribute("ka");
//
////       void removeAttribute(String key);  移除域中的数据
//        servletContext1.removeAttribute("ka");
    }
}
