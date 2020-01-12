package com.ly.springmvc.handler;

import com.ly.springmvc.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author luoyong
 * @Description: SpringMvcHandler
 * @create 2020-01-12 10:14
 * @last modify by [LuoYong 2020-01-12 10:14]
 **/
@Controller
@RequestMapping("/mvc")
public class SpringMVCHandler {


    @RequestMapping("/testPOJO")
    public String testPOJO(User user) {
        System.out.println("user:" + user);
        return "success";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: 映射cookie信息到请求处理方法的形参中
     * @author luoyong
     * @create 18:49 2020/1/12
     * @last modify by [LuoYong 18:49 2020/1/12 ]
     */
    @RequestMapping("testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("sessionId:" + sessionId);
        return "success";
    }


    /**
     * @param acceptLanguage
     * @return java.lang.String
     * @Description: 映射请求头信息到请求处理方法的形参中
     * @author luoyong
     * @create 18:42 2020/1/12
     * @last modify by [LuoYong 18:42 2020/1/12 ]
     */
    @RequestMapping("testRequestHeader")
    public String testRequestHeader(@RequestHeader("Accept-Language") String acceptLanguage) {
        System.out.println("acceptLanguage:" + acceptLanguage);
        return "success";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: 与请求路径：http://localhost:8088/springmvc/mvc/testRequestMapping 进行匹配
     * @author luoyong
     * @create 10:28 2020/1/12
     * @last modify by [LuoYong 10:28 2020/1/12 ]
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        return "success";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: @RequestMapping method 属性 映射请求方式
     * @author luoyong
     * @create 10:43 2020/1/12
     * @last modify by [LuoYong 10:43 2020/1/12 ]
     */
    @RequestMapping(value = "/testRequestMappingMethod", method = {RequestMethod.PUT, RequestMethod.GET})
    public String testRequestMappingMethod() {
        return "success";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: testRequestMappingParamsAndHeaders
     * 映射请求参数   以及  请求头信息
     * http://localhost:8088/springmvc/mvc/testRequestMappingParamsAndHeaders?username=tom&age=22
     * 注意:headers = {"!Accept-Language"} 没有语言信息会找不到对应处理器 报404
     * AnnotationMethodHandlerAdapter  resolveHandlerMethod 566
     * @author luoyong
     * @create 10:52 2020/1/12
     * @last modify by [LuoYong 10:52 2020/1/12 ]
     */
    @RequestMapping(value = "/testRequestMappingParamsAndHeaders", method = RequestMethod.GET,
            params = {"username", "age"}, headers = {"!Accept-Language"})
    public String testRequestMappingParamsAndHeaders() {
        return "success";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: 测试带占位符的url
     * http://localhost:8088/springmvc/mvc/testPathVariable/Admin/1001
     * @author luoyong
     * @create 16:36 2020/1/12
     * @last modify by [LuoYong 16:36 2020/1/12 ]
     */
    @RequestMapping("/testPathVariable/{name}/{id}")
    public String testPathVariable(@PathVariable("name") String name, @PathVariable("id") Integer id) {
        System.out.println(name + " : " + id);
        return "success";
    }


    @RequestMapping(value = "order/{id}", method = RequestMethod.GET)
    public String testRestGET(@PathVariable("id") Long id) {
        System.out.println("testRestGET...id:" + id);
        return "success";
    }


    /**
     * @param id
     * @return java.lang.String
     * @Description: testRestDELETE
     * 配置REST拦截器 HiddenHttpMethodFilter
     * 消息 JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS
     * 描述 请求行中接收的方法由源服务器知道，但目标资源不支持
     * 解决办法：加@ResponseBody注解
     * @author luoyong
     * @create 17:09 2020/1/12
     * @last modify by [LuoYong 17:09 2020/1/12 ]
     */
    @ResponseBody
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public String testRestDELETE(@PathVariable("id") Long id) {
        System.out.println("REST DELETE: " + id);
        return "success";
    }

    /**
     * @param
     * @return java.lang.String
     * @Description: Type Status Report
     * 消息 JSP 只允许 GET、POST 或 HEAD。Jasper 还允许 OPTIONS
     * 描述 请求行中接收的方法由源服务器知道，但目标资源不支持
     * 解决办法：加@ResponseBody注解
     * @author luoyong
     * @create 17:30 2020/1/12
     * @last modify by [LuoYong 17:30 2020/1/12 ]
     */
    @ResponseBody
    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public String testRestPUT() {
        System.out.println("REST PUT");
        return "success";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String testRestPOST() {
        System.out.println("REST POST");
        return "success";
    }

    /**
     * @param userName
     * @param age
     * @return java.lang.String
     * @Description: testRequestParam  映射请求参数到请求处理方法的形参
     * 1. 如果请求参数名与形参名一致， 则可以省略@RequestParam的指定。
     * 2. @RequestParam 注解标注的形参必须要赋值。 必须要能从请求对象中获取到对应的请求参数。
     * 可以使用required来设置为不是必须的。
     * 3. 可以使用defaultValue来指定一个默认值取代null
     * http://localhost:8088/springmvc/mvc/testRequestParam?username=Tom&age=22
     * @author luoyong
     * @create 17:56 2020/1/12
     * @last modify by [LuoYong 17:56 2020/1/12 ]
     */
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam("username") String userName, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        //web: request.getParameter()    request.getParameterMap()
        System.out.println("testRequestParam...username=" + userName + " age=" + age);
        return "success";
    }

}
