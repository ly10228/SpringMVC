package com.ly.springmvc.crud.dao;

import com.ly.springmvc.crud.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author luoyong
 *  * @create 2020-01-22 下午8:46
 *  * @last modify by [luoyong 2020-01-22 下午8:46]
 * @Description: 部门增删改查
 **/
@Repository
public class DepartmentDao {

    private static Map<Integer, Department> departmentMap = null;

    static {
        departmentMap = new HashMap<>();
        departmentMap.put(101, new Department(101, "D-AA"));
        departmentMap.put(102, new Department(102, "D-BB"));
        departmentMap.put(103, new Department(103, "D-CC"));
        departmentMap.put(104, new Department(104, "D-DD"));
        departmentMap.put(105, new Department(105, "D-EE"));
    }


    /**
     * @return
     * @Description: 获取所有的部门信息
     * @author luoyong
     * @create 下午9:03 2020/1/22
     * @last modify by [LuoYong 下午9:03 2020/1/22 ]
     */
    private List<Department> listAllDept() {
        return (List<Department>) departmentMap.values();
    }

    /**
     * @param deptId 部门id
     * @return
     * @Description: 根据部门id获取部门信息
     * @author luoyong
     * @create 下午9:04 2020/1/22
     * @last modify by [LuoYong 下午9:04 2020/1/22 ]
     */
    public Department getDeptById(Integer deptId) {
        return departmentMap.get(deptId);
    }


}

