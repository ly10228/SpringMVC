package com.ly.springmvc.crud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 *  * @create 2020-01-22 下午8:41
 *  * @last modify by [luoyong 2020-01-22 下午8:41]
 * @Description: 员工
 **/
@Data
public class Employee implements Serializable {
    /**
     * 员工id
     */
    private Integer id;

    private String lastName;

    private String email;

    /**
     * l male 2 female
     */
    private Integer gender;

    /**
     * 部门信息
     */
    private Department department;

    public Employee() {
    }

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }
}
