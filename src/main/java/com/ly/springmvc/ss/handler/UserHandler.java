package com.ly.springmvc.ss.handler;

import com.ly.springmvc.ss.beans.Person;
import com.ly.springmvc.ss.beans.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserService userService;

    public UserHandler() {
        System.out.println("UserHandler .....");
    }

    @RequestMapping("/hello")
    public String hello(HttpSession session) {
        userService.hello();

        ServletContext sc = session.getServletContext();

        //SpringIOC容器对象
        //ApplicationContext ctx = (ApplicationContext)sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

        //工具类
        ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);

        Person person = ctx.getBean("person", Person.class);

        person.sayHello();

        return "success";
    }
}
