package com.ly.springmvc.crud.handler;

import com.google.common.collect.Maps;
import com.ly.springmvc.crud.dao.DepartmentDao;
import com.ly.springmvc.crud.dao.EmployeeDao;
import com.ly.springmvc.crud.entity.Department;
import com.ly.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
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

    /**
     * @param map
     * @return
     * @Description: 去往添加页面 添加页面所需要的数据
     * @author luoyong
     * @create 上午11:47 2020/1/26
     * @last modify by [LuoYong 上午11:47 2020/1/26 ]
     */
    @RequestMapping(value = "/emp", method = {RequestMethod.GET})
    public String toAddPage(Map<String, Object> map) {
        //1:查询所有的部门信息
        List<Department> departments = departmentDao.listAllDept();
        map.put("depts", departments);

        //2:构造页面中生成单选框的数据
        Map<String, String> genders = Maps.newHashMap();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);

        //3:设置页面当中要回显的数据
        map.put("employee", new Employee());

        return "input";
    }


    /**
     * @param employee
     * @return
     * @Description: 添加员工
     * @author luoyong
     * @create 下午12:17 2020/1/26
     * @last modify by [LuoYong 下午12:17 2020/1/26 ]
     */
    @RequestMapping(value = "/emp", method = RequestMethod.POST)
    public String addEmp(Employee employee) {
        //添加员工
        employeeDao.save(employee);
        //回到列表页面 :重定向到显示所有员工信息列表的请求.
        return "redirect:/listAllEmp";
    }

    /**
     * @param id 员工id
     * @return
     * @Description: 删除某一个员工信息
     * AnnotationMethodHandlerAdapter 566 查询方法匹配
     * @author luoyong
     * @create 下午12:32 2020/1/26
     * @last modify by [LuoYong 下午12:32 2020/1/26 ]
     */
    @RequestMapping(value = "/emp/{id}", method = {RequestMethod.DELETE})
    public String deleteEmp(@PathVariable("id") Integer id) {
        employeeDao.del(id);
        return "redirect:/listAllEmp";
    }

    /**
     * @param id  员工id
     * @param map
     * @return java.lang.String
     * @Description: 修改功能 去往修改页面你
     * @author luoyong
     * @create 下午1:01 2020/1/26
     * @last modify by [LuoYong 下午1:01 2020/1/26 ]
     */
    @RequestMapping(value = "/emp/{id}", method = RequestMethod.GET)
    public String toUpdatePage(@PathVariable("id") Integer id, Map<String, Object> map) {
        //查询要修改的员工信息
        Employee employee = employeeDao.get(id);
        map.put("employee", employee);

        //页面中显示部门下拉列表的数据
        List<Department> depts = departmentDao.listAllDept();
        map.put("depts", depts);

        //页面中生成性别单选框的数据
        Map<String, String> genders = new HashMap<>();
        genders.put("0", "女");
        genders.put("1", "男");
        map.put("genders", genders);
        //去往修改页面
        return "input";
    }

    /**
     * @param employee
     * @return
     * @Description: 具体修改功能
     * @author luoyong
     * @create 下午1:02 2020/1/26
     * @last modify by [LuoYong 下午1:02 2020/1/26 ]
     */
    @RequestMapping(value = "/emp", method = RequestMethod.PUT)
    public String updateEmp(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/listAllEmp";
    }
}
