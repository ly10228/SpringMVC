package com.ly.springmvc.dto;

import lombok.Data;

/**
 * @author luoyong
 * @Description: User
 * @create 2020-01-12 18:56
 * @last modify by [LuoYong 2020-01-12 18:56]
 **/
@Data
public class User {
    private String userName;
    private String passWord;
    private String email;
    private Integer gender;
    private Address address;
}
