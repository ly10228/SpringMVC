package com.ly.springmvc.testjson;

import com.ly.springmvc.crud.dao.EmployeeDao;
import com.ly.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.List;

/**
 * @author luoyong
 *  * @create 2020-01-26 下午3:47
 *  * @last modify by [luoyong 2020-01-26 下午3:47]
 * @Description: 测试json
 **/
@Controller
public class TestJsonHandler {


    @Autowired
    EmployeeDao employeeDao;

    /**
     * @return
     * @Description: 处理JSON
     * ResponseBody 负责将方法的返回值 转化成json字符串 响应给浏览器端.
     * @author luoyong
     * 源码
     * HttpMessageConverter
     * DispatcherServlet
     * 945 DispatcherServlet对象
     * --handlerAdapters
     * --RequestMappingHandlerAdapters
     * --messageConverters
     * --org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
     * @create 下午3:50 2020/1/26
     * @last modify by [LuoYong 下午3:50 2020/1/26 ]
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public List<Employee> testJson() {
        List<Employee> employees = employeeDao.listAllEmInfo();
        return employees;
    }


    /**
     * @param httpSession
     * @return
     * @Description:  文件下载
     * 使用HttpMessageConveter完成下载功能
     * 支持@RequestBody   @ResponseBody   HttpEntity  ResponseEntity
     * 原理：
     *    将服务器端的文件以流的形式写到客户端
     *ResponseEntity：将要下载的文件数据 以及响应信息封装到ResponseEntity当中。浏览器通过解析发送回去的响应数据，就可以进行一个下载操作
     * @author luoyong
     * @create 下午4:40 2020/1/26
     * @last modify by [LuoYong 下午4:40 2020/1/26 ]
     */
    @RequestMapping("/download")
    public ResponseEntity<byte[]> testDownload(HttpSession httpSession) throws Exception {
        //1:将要下载的文件读取成一个字节数组
        byte[] imgs;
        ServletContext servletContext = httpSession.getServletContext();
        InputStream in = servletContext.getResourceAsStream("images/Spring处理JSON数据原理.png");
        imgs = new byte[in.available()];
        in.read(imgs);

        //将响应数据 以及一些响应头信息封装到ResponseEntity当中
        /**
         * 参数
         *   1:发送浏览器端的数据
         *   2:设置响应头
         *   3:设置响应码
         */
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment;filename=Spring处理JSON数据原理.png");
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> re = new ResponseEntity<>(imgs, headers, statusCode);
        return re;
    }
}
