package com.ly.springmvc.ss.listener;

import com.ly.springmvc.ss.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

/**
 * @author luoyong
 *  * @create 2020-01-29 下午1:10
 *  * @last modify by [luoyong 2020-01-29 下午1:10]
 * @Description: 自定义监听器
 **/
@WebListener
public class MyServletContextListener implements ServletContextListener {

    /**
     * @param sce
     * @return void
     * @Description: 当监听到ServletContext对象被创建，就执行该方法
     * @author luoyong
     * @create 下午1:11 2020/1/29
     * @last modify by [LuoYong 下午1:11 2020/1/29 ]
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //1:创建SpringIOC容器对象
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        System.out.println("创建SpringIOC容器对象完成");
        //2:将SpringIoc容器对象绑定到ServletContext对象当中
        ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("applicationContext",applicationContext);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
