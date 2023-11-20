package com.gzzz.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * className: Filter1
 * Package : com.gzzz.filter
 * Description:
 *      TODO:
 *           如果使用web.xml配置过滤器，则过滤器链的顺序由filter-mapping的顺序决定
 *           如果使用@webFilter注解，则过滤器链的顺序由过滤器的类名大小顺序决定
 * @Author gzzz
 * @Create 2023/11/20 18:06
 * @Version 1.0
 */
@WebFilter("/*")
public class Filter1 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter1 before doFilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter1 after doFilter invoked");

    }
}
