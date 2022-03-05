package com.zzmax.filterlistenerlearn.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FilterDemo1 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器1初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("111111");
        // 放行
        filterChain.doFilter(servletRequest,servletResponse);

        System.out.println("333333");
    }

    @Override
    public void destroy() {
        System.out.println("过滤器1销毁");
    }
}
