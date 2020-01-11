package com.ly.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luoyong
 * @Description: SpringMVCHandler
 * @create 2020-01-11 11:46
 * @last modify by [LuoYong 2020-01-11 11:46]
 **/
@Controller
public class SpringMVCHandler {

    /**
     * @param
     * @return java.lang.String
     * @Description: 处理客户端的请求  http://localhost:8080/springmvc/hello
     * @author luoyong
     * @create 11:53 2020/1/11
     * @last modify by [LuoYong 11:53 2020/1/11 ]
     */
    @RequestMapping("/hello")
    public String handlerHello() {
        System.out.println("Hello SpringMVC");
        // 通过视图解析器解析得到具体的视图， 再转发去往该视图.
        return "helloWorld";
    }
}
