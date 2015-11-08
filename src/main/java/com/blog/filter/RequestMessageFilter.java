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
 * 拦截器
 * 拦截所有请求(不包括静态文件的请求如:js,css等)
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

        /** 请求过来的URI **/
        String requestURI = request.getRequestURI();
        /** 请求过来的URL **/
        StringBuffer requestURL = request.getRequestURL();
        /** 请求方式 **/
        String method = request.getMethod();
        /** 请求Session内容 **/
        Enumeration<String> sessionAttributeNames = request.getSession().getAttributeNames();
        /** 请求者的IP地址 **/
        String remoteAddr = request.getRemoteAddr();
        // 如果请求过来的URI不带 ".*"
        if ( !requestURI.contains(".") ) {
            logger.info("请求URL : " + requestURL);
            logger.info("请求URI : " + requestURI);
            logger.info("请求方式 : " + method);
            logger.info("请求者IP : " + remoteAddr);
            while (sessionAttributeNames.hasMoreElements()) {
                logger.info("Session内容 : " + sessionAttributeNames.nextElement());
            }
        }
    }


    public void init (FilterConfig config) throws ServletException {

    }

}
