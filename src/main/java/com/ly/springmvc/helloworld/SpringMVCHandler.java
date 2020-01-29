package com.ly.springmvc.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author luoyong
 * @Description: SpringMVCHandler
 * @create 2020-01-11 11:46
 * @last modify by [LuoYong 2020-01-11 11:46]
 **/
@Controller("helloWorld")
public class SpringMVCHandler {

    /**
     * @param
     * @return java.lang.String
     * @Description: 处理客户端的请求  http://localhost:8080/springmvc/hello
     * @RequestMapping("/hello") 里面的值是用来做匹配的 不是一个路径 ‘/’写不写都可以
     * 流程
     * 1）用户向服务器发送请求，请求被SpringMVC 前端控制器 DispatcherServlet捕获；
     * 2）DispatcherServlet对请求URL进行解析，得到请求资源标识符（URI）:
     * 判断请求URI对应的映射
     * ①不存在：
     * 再判断是否配置了mvc:default-servlet-handler：
     * 如果没配置，则控制台报映射查找不到，客户端展示404错误
     * 如果有配置，则执行目标资源（一般为静态资源，如：JS,CSS,HTML）
     * ②存在：
     * 执行下面流程
     * 3）根据该URI，调用HandlerMapping获得该Handler配置的所有相关的对象（包括Handler对象以及Handler对象对应的拦截器），最后以
     * HandlerExecutionChain对象的形式返回；
     *      HandlerMapping 定义了请求与请求处理器的映射
     *      HandlerExecutionChain  执行链 包含处理器加拦截器
     *      902
     *      916 被初始化 （1095）
     *
     * 4）DispatcherServlet 根据获得的Handler，选择一个合适的HandlerAdapter。
     *     HandlerAdapter 处理器适配器 	使用Handler调用对应的方法
     *     923   （945）
     *
     * 5）如果成功获得HandlerAdapter后，此时将开始执行拦截器的preHandler(...)方法【正向】
     *     939
     *     !mappedHandler.applyPreHandle(processedRequest, response) mappedHandler 里面包含了处理器和拦截器
     *
     * 6）提取Request中的模型数据，填充Handler入参，开始执行Handler（Controller)方法，处理请求。在填充Handler的入参过程中，根据你的配置，Spring将帮你做一些额外的工作：
     * ①HttpMessageConveter： 将请求消息（如Json、xml等数据）转换成一个对象，将对象转换为指定的响应信息
     * ②数据转换：对请求消息进行数据转换。如String转换成Integer、Double等
     * ③数据根式化：对请求消息进行数据格式化。 如将字符串转换成格式化数字或格式化日期等
     * ④数据验证： 验证数据的有效性（长度、格式等），验证结果存储到BindingResult或Error中
     * 7）Handler执行完成后，向DispatcherServlet 返回一个ModelAndView对象；
     * 8）此时将开始执行拦截器的postHandle(...)方法【逆向】
     *     954
     *     mappedHandler.applyPostHandle(processedRequest, response, mv);
     * 9）根据返回的ModelAndView（此时会判断是否存在异常：如果存在异常，则执行HandlerExceptionResolver进行异常处理）选择一个适合的ViewResolver（必须是已经注册到Spring容器中的ViewResolver)返回给DispatcherServlet，根据Model和View，来渲染视图
     * 10）在返回给客户端时需要执行拦截器的AfterCompletion方法【逆向】
     * 11）将渲染结果返回给客户端
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
