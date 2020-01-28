package com.ly.springmvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author luoyong
 *  * @create 2020-01-28 下午10:20
 *  * @last modify by [luoyong 2020-01-28 下午10:20]
 * @Description: 自定义拦截器
 **/
public class MySecondInterceptor implements HandlerInterceptor {
    /**
     * @param request
     * @param response
     * @param handler
     * @return boolean
     * @Description: 1. 是在DispatcherServlet的939行   在请求处理方法之前执行
     * @author luoyong
     * @create 下午10:17 2020/1/28
     * @last modify by [LuoYong 下午10:17 2020/1/28 ]
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("{MySecondInterceptor  preHandle}");
        return false;
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @return void
     * @Description: 2. 在DispatcherServlet 959行   请求处理方法之后，视图处理之前执行。
     * @author luoyong
     * @create 下午10:19 2020/1/28
     * @last modify by [LuoYong 下午10:19 2020/1/28 ]
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("{MySecondInterceptor postHandle}");
    }

    /**
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @return void
     * @Description:
     * [1].在DispatcherServlet的 1030行   视图处理之后执行.(转发/重定向后执行 1012)
     * [2].当某个拦截器的preHandle返回false后，也会执行当前拦截器之前拦截器的afterCompletion
     * @author luoyong
     * @create 下午10:19 2020/1/28
     * @last modify by [LuoYong 下午10:19 2020/1/28 ]
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("{MySecondInterceptor afterCompletion}");
    }
}
