package com.imonkeyz.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Jesse.Zhou on 2016/4/12 0012.
 */
public class AntiLeechInterceptor implements HandlerInterceptor{
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        final String referer = request.getHeader("Referer");
        if(referer==null){
            //System.out.println("referer is " + referer + ", anti-leech active !");
            request.getRequestDispatcher("/js_css/images/antiLeech.jpg").forward(request, response);
        }
        //System.out.println("referer check passed : " + referer);
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
