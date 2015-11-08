package com.blog.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * 拦截器
 * 拦截所有请求
 * @author : 余峻豪
 * @date : 15/11/8
 */
public class RequestMessageInterceptor  extends HandlerInterceptorAdapter {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Override
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ( handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            logger.info("请求控制器 : " + handlerMethod.getBean());
            logger.info("请求方法名 : " + handlerMethod.getMethod());
        }

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
        return true;
    }
}
