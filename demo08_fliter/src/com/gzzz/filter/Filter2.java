package com.gzzz.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

/**
 * className: Filter1
 * Package : com.gzzz.filter
 * Description:
 *
 * @Author gzzz
 * @Create 2023/11/20 18:06
 * @Version 1.0
 */
@WebFilter("/*")
public class Filter2 implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter2 before doFilter invoked");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter2 after doFilter invoked");
    }
}
