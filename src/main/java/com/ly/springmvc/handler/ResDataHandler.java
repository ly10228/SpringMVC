package com.ly.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @author luoyong
 * @Description: ResDataHandler
 * @create 2020-01-12 22:17
 * @last modify by [LuoYong 2020-01-12 22:17]
 **/
@Controller
public class ResDataHandler {

    /**
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     * @Description: testModelAndView
     * 结论：SpringMvc会把ModelAndView中的模型数据存放到request域对象中
     * 源码：
     * 1:DispatcherServlet
     * 945 返回ModeAndView
     * 959 处理结果ModeAndView
     * 1012 解析得到一个视图对象
     * 1204 view对象赋值 InternalResourceView
     * 1225视图对象处理模型数据
     * AbstractView
     * 266 视图输出对象
     * InternalResourceView
     * 180 Expose the model object as request attributes
     * AbstractView
     * 369 设置视图对象到request域当中
     * InternalResourceView
     * 189  Obtain a RequestDispatcher for the target resource (typically a JSP).
     * 209  forward()转发
     * @author luoyong
     * @create 22:27 2020/1/12
     * @last modify by [LuoYong 22:27 2020/1/12 ]
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        //模型数据: userName=Admin
        ModelAndView modelAndView = new ModelAndView();
        //添加模型数据
        modelAndView.addObject("userName", "Admin");
        //设置视图信息
        modelAndView.setViewName("resData");
        return modelAndView;
    }

    /**
     * @param map
     * @return java.lang.String
     * @Description: Spring Mvc会把Map当中的模型数据存放到request域对象中
     * SpringMVC再调用完请求处理方法后，不管方法的返回值是什么类型，都会处理成一个ModelAndView对象（参考DispatcherServlet的945行）
     * @author luoyong
     * @create 23:20 2020/1/12
     * @last modify by [LuoYong 23:20 2020/1/12 ]
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map) {
        //数据模型passWorld=123456;
        //org.springframework.validation.support.BindingAwareModelMap
        System.out.println(map.getClass().getName());
        map.put("passWorld", "123456");
        return "resData";
    }


    /**
     * @param
     * @return java.lang.String
     * @Description: testModel
     * @author luoyong
     * @create 23:23 2020/1/12
     * @last modify by [LuoYong 23:23 2020/1/12 ]
     */
    @RequestMapping("/testModel")
    public String testModel(Model model) {
        //模型数据 : loginMsg=用户名或者密码错误
        model.addAttribute("loginMsg", "用户名或者密码错误");
        return "resData";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: 视图 View
     * @author luoyong
     * @create 23:28 2020/1/12
     * @last modify by [LuoYong 23:28 2020/1/12 ]
     */
    @RequestMapping("/testView")
    public String testView() {
        return "resData";
    }


    /**
     * @param
     * @return java.lang.String
     * @Description: 重定向
     * @author luoyong
     * @create 23:28 2020/1/12
     * @last modify by [LuoYong 23:28 2020/1/12 ]
     */
    @RequestMapping("/testRedirectView")
    public String testRedirectView() {
        return "redirect:/ok.jsp";
    }


}
