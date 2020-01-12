package com.ly.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
     *      945 返回ModeAndView
     *      959 处理结果ModeAndView
     *      1012 解析得到一个视图对象
     *      1204 view对象赋值 InternalResourceView
     *      1225视图对象处理模型数据
     * AbstractView
     *      266 视图输出对象
     * InternalResourceView
     *      180 Expose the model object as request attributes
     * AbstractView
     *       369 设置视图对象到request域当中
     * InternalResourceView
     *       189  Obtain a RequestDispatcher for the target resource (typically a JSP).
     *       209  forward()转发
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
}
