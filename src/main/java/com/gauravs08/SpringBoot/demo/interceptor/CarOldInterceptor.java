package com.gauravs08.SpringBoot.demo.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * @author Gaurav Sharma
 *
 */
public class CarOldInterceptor extends HandlerInterceptorAdapter {
 
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
 
        System.out.println("\n===== CarOldInterceptor.preHandle() ==== ");
        System.out.println("Request URL: " + request.getRequestURL());
        System.out.println("Sorry! This URL is old and no longer used, Redirect to /api/cars\n");
 
        response.sendRedirect(request.getContextPath() + "/api/cars");
        return false;
    }
 
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, //
            Object handler, ModelAndView modelAndView) throws Exception {
 
        // This code will never be run.
        System.out.println("\\n===== CarOldInterceptor.postHandle() ==== ");
    }
 
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, //
            Object handler, Exception ex) throws Exception {
         
        // This code will never be run.
        System.out.println("\\n===== CarOldInterceptor.afterCompletion() ==== ");
    }
 
}