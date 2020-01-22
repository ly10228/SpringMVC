package com.ly.springmvc.crud.dao;

import com.google.common.collect.Lists;
import com.ly.springmvc.crud.entity.Department;
import com.ly.springmvc.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoyong
 *  * @create 2020-01-22 下午8:41
 *  * @last modify by [luoyong 2020-01-22 下午8:41]
 * @Description: 员工增删改查
 **/
@Repository
public class EmployeeDao {
    @Autowired
    DepartmentDao departmentDao;

    private static Map<Integer, Employee> employeeMap = null;

    static {
        employeeMap = new HashMap<>();
        employeeMap.put(1001, new Employee(1001, "E-AA", "aa@163.com", 1, new Department(101, "D-AA")));
        employeeMap.put(1002, new Employee(1002, "E-BB", "bb@163.com", 1, new Department(102, "D-BB")));
        employeeMap.put(1003, new Employee(1003, "E-CC", "cc@163.com", 0, new Department(103, "D-CC")));
        employeeMap.put(1004, new Employee(1004, "E-DD", "dd@163.com", 0, new Department(104, "D-DD")));
        employeeMap.put(1005, new Employee(1005, "E-EE", "ee@163.com", 1, new Department(105, "D-EE")));
    }

    /**
     * 初始化id大小为1006
     */
    private static Integer initId = 1006;

    /**
     * @param employee 员工信息
     * @return
     * @Description: 保存员工信息
     * @author luoyong
     * @create 下午9:09 2020/1/22
     * @last modify by [LuoYong 下午9:09 2020/1/22 ]
     */
    public Boolean save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDeptById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
        return true;
    }

    /**
     * @return
     * @Description: 获取所有的员工信息
     * @author luoyong
     * @create 下午9:20 2020/1/22
     * @last modify by [LuoYong 下午9:20 2020/1/22 ]
     */
    public List<Employee> listAllEmInfo() {
        List<Employee> employees = Lists.newArrayList();
        employeeMap.values().forEach(item -> employees.add(item));
        return employees;
    }

    /**
     * @param id 员工id
     * @return
     * @Description: 根据员工id获取员工信息
     * @author luoyong
     * @create 下午9:21 2020/1/22
     * @last modify by [LuoYong 下午9:21 2020/1/22 ]
     */
    public Employee get(Integer id) {
        return employeeMap.get(id);
    }

    /**
     * @param id 员工id
     * @return
     * @Description: 根据员工id删除员工信息
     * @author luoyong
     * @create 下午9:23 2020/1/22
     * @last modify by [LuoYong 下午9:23 2020/1/22 ]
     */
    public Boolean del(Integer id) {
        if (employeeMap.containsKey(id)) {
            employeeMap.remove(id);
        }
        return true;
    }
}
