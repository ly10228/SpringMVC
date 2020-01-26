package com.ly.springmvc.testjson;

import com.ly.springmvc.crud.dao.EmployeeDao;
import com.ly.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
     * @create 下午3:50 2020/1/26
     * @last modify by [LuoYong 下午3:50 2020/1/26 ]
     */
    @ResponseBody
    @RequestMapping("/testJson")
    public List<Employee> testJson() {
        List<Employee> employees = employeeDao.listAllEmInfo();
        return employees;
    }
}
