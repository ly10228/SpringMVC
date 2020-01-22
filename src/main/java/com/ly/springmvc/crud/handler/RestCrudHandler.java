package com.ly.springmvc.crud.handler;

import com.ly.springmvc.crud.dao.DepartmentDao;
import com.ly.springmvc.crud.dao.EmployeeDao;
import com.ly.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

/**
 * @author luoyong
 *  * @create 2020-01-22 下午9:25
 *  * @last modify by [luoyong 2020-01-22 下午9:25]
 * @Description: 员工增删改查
 **/
@Controller
public class RestCrudHandler {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private EmployeeDao employeeDao;


    /**
     * @param map
     * @return
     * @Description: 获取所有的员工信息
     * @author luoyong
     * @create 下午9:27 2020/1/22
     * @last modify by [LuoYong 下午9:27 2020/1/22 ]
     */
    @RequestMapping(value = "/listAllEmp", method = {RequestMethod.GET})
    public String listAllEmp(Map<String, Object> map) {
        List<Employee> employees = employeeDao.listAllEmInfo();
        //map当中的数据会存放到request域对象当中
        map.put("emps", employees);
        return "list";
    }

}
