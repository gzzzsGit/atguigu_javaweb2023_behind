package com.gzzz.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * className: LifeCircleServlet
 * Package : com.gzzz.servlet
 * Description:
 *      TODO:
 *           Servlet在Tomcat中是单例的
 *           Servlet的成员变量在多个线程栈之中是共享的
 *           不建议在service方法中修改成员变量―在并发请求时,会引发线程安全问题
 *
 *
 *      TODO:
 *           loadOnStartup的默认值是-1，表示服务启动时不实例化、初始化，第一次请求时才实例化、初始化
 *           loadOnStartup设置为正整数时表示服务启动时就实例化、初始化，数字表示多个servlet之间的启动顺序优先级，可以重复，此时tomcat会自动决定顺序
 *           建议loadOnStartup设置为6之后的数字，因为tomcat自带的web.xml中设置的loadOnStartup值已经占用了1-5
 * @Author gzzz
 * @Create 2023/11/15 16:54
 * @Version 1.0
 */
@WebServlet(name = "LifeCircleServlet", urlPatterns = {"/LifeCircleServlet"},loadOnStartup = 10)
public class LifeCircleServlet extends HttpServlet {
    public LifeCircleServlet() {
        System.out.println("实例化");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("初始化");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service...");
    }

    //关闭服务时销毁
    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
