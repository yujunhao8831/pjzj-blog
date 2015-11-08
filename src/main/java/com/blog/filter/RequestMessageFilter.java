package com.blog.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;

/**
 * 过滤器
 */
@WebFilter(filterName = "RequestMessageFilter",urlPatterns = "/*")
public class RequestMessageFilter implements Filter {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public void destroy () {
    }

    public void doFilter (ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
    }


    public void init (FilterConfig config) throws ServletException {

    }

}
