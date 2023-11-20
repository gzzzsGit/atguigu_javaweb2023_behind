package com.gzzz.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * className: LifeCycleFilter
 * Package : com.gzzz.filter
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/19 20:20
 * @Version 1.0
 */

/**
 *  1 构造   构造器   项目启动(tomcat部署)     1
 *  2 初始化  init   构造完毕(tomcat部署)     1
 *  3 过滤   doFilter  每次请求      多次
 *  4 销毁   destroy  服务关闭   1
 *
 */
@WebServlet("/filter")
public class LifeCycleFilter implements Filter {
    public LifeCycleFilter() {
        System.out.println("构造");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("过滤方法");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
        System.out.println(filterConfig.getInitParameter("dateTimePattern"));
    }

    @Override
    public void destroy() {
        System.out.println("销毁方法");
    }
}
