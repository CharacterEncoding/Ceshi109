package com.he.ceshi109.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        String uri = req.getRequestURI();
        if (uri.contains("login.do") || uri.contains("toLogin.do") || uri.contains("toReg.do") || uri.contains("reg.do") || uri.contains("img.do")) {
            chain.doFilter(req,resp);
        } else {
            Object name = req.getSession().getAttribute("name");
            if (name != null) {
                chain.doFilter(req,resp);
            } else {
                resp.sendRedirect("toLogin.do");
            }
        }
    }

    @Override
    public void destroy() {

    }
}
