package com.gzzz.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * className: Servlet3
 * Package : com.gzzz.servlet
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/15 22:03
 * @Version 1.0
 */
@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();

       // 获取一个指向项目部署位置下的某个文件/目录的磁盘真实路径API
        String path = servletContext.getRealPath("upload");
        System.out.println(path);//D:\code\workspace_IDEA\atguigu_javaweb2023\out\artifacts\demo03_servletConfig_servletContext_war_exploded\\upload
        FileOutputStream fos = new FileOutputStream(path + "/a.txt");
        fos.write("this is a test!".getBytes());
        fos.close();

        // 获取项目部署的上下文路径     项目的访问路径
        // 由于之后在项目后会使用相对和绝对路径寻找目标资源
        // 获取项目的上下文路径 getContextPath()
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);//demo03
    }
}
