package com.zzmax.filterlistenerlearn.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = "/*",filterName = "loginFilter")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        //登陆状态校验逻辑代码
//        HttpServletRequest request = (HttpServletRequest) servletRequest;
//        // 取出session，并取出user
//        HttpSession session = request.getSession();
//        Object user = session.getAttribute("user");
//
//        String msg = "";
//
//        if (user != null) {
//            // 登陆过了，放行
//            filterChain.doFilter(servletRequest,servletResponse);
//        }
//        else {
//            // 没有登陆，直接跳到登陆页面
//            msg = "没有登陆";
//
//            request.setAttribute("msg",msg);
//            request.getRequestDispatcher("/login.jsp").forward(request,servletResponse);
//        }

        HttpServletRequest request01 = (HttpServletRequest) servletRequest;
        String[] urls = {"/login.jsp" , "/img/" , "/css/" , "/js" , "/loginServlet" , "/register.jsp" , "/registerServlet" , "/verifyCodeServlet"};
        String url =  request01.getRequestURL().toString();
        for (String u : urls){
            if (url.contains(u)){
                filterChain.doFilter(servletRequest,servletResponse);
                return;
            }
        }
        HttpSession session = request01.getSession();
        Object user = session.getAttribute("user");
        if (user != null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            String msg = "当前用户没有登录";
            servletRequest.setAttribute("msg",msg);
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
        }


    }

    @Override
    public void destroy() {
        System.out.println("过滤器销毁");
    }
}
