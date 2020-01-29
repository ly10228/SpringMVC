package com.ly.springmvc.ss.servlet;

import com.ly.springmvc.ss.beans.Person;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author luoyong
 *  * @create 2020-01-29 下午1:08
 *  * @last modify by [luoyong 2020-01-29 下午1:08]
 * @Description: servlet
 **/
@WebServlet("/helloServlet")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //访问到SpringIOC容器中的person对象.
        //从ServletContext对象中获取SpringIOC容器对象
        ServletContext sc = getServletContext();

        ApplicationContext ctx =  (ApplicationContext)sc.getAttribute("applicationContext");

        Person person = ctx.getBean("person",Person.class);

        person.sayHello();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
