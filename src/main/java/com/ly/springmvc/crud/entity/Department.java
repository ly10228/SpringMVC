package com.ly.springmvc.crud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author luoyong
 *  * @create 2020-01-22 下午8:43
 *  * @last modify by [luoyong 2020-01-22 下午8:43]
 * @Description:  部门信息
 **/
@Data
public class Department implements Serializable {
    /**
     * 部门id
     */
    private Integer id;

    /**
     * 部门名称
     */
    private String departmentName;

    public Department() {
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }
}
