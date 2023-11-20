package com.gzzz.filter;

import com.gzzz.servlet.Servlet1;
import com.sun.tools.attach.AgentInitializationException;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * className: LoggingFilter
 * Package : com.gzzz.fliter
 * Description:
 *  日志过滤器  记录请求的历史  将日志打印到控制台
 *  1  实现filter接口
 *  2  重写过滤方法
 *  3  配置过滤器
 *      web+xml
 *      注解
 * @Author gzzz
 * @Create 2023/11/19 17:42
 * @Version 1.0
 */
public class LoggingFilter implements Filter {
    private SimpleDateFormat datefmt = new SimpleDateFormat("yyyy=MM-dd HH:mm:ss");
    /**
     * 过滤请求和响应的方法
     *      1 请求到达目标资源之前，先经过该方法
     *      2 该方法有能力控制请求是否继续向后到达目标资源 可以在该方法内直接向客户端做响应处理
     *      3 请求到达目标资源后，响应之前，还会经过该方法
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        
        /**
         *  1 请求到达目标资源之前的功能代码
         *      判断是否登录
         *      校验权限是否满足
         *  2 放行代码
         *  3 响应之前  HttpServletResponse 转换为响应报文之前的功能代码
         */
        // 请求到达目标资源之前的代码
        String requstURI = req.getRequestURI();
        String dateTime = datefmt.format(new Date());
        String beforeLoggin =requstURI+"在"+dateTime+"被访问了";
        System.out.println(beforeLoggin);
        long time1 = System.currentTimeMillis();

        // 放行,如果没有这一行代码，请求不会到达目标资源
        filterChain.doFilter(servletRequest,servletResponse);

        // 响应之前的功能代码
        long time2  = System.currentTimeMillis();
        String afterLoggin = requstURI + "资源在" + dateTime + "的请求耗时: " + Long.toString(time2 - time1) + "毫秒";
        System.out.println(afterLoggin);

    }
}
