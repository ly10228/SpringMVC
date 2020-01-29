package com.ly.springmvc.ss.config;

import com.ly.springmvc.ss.beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author luoyong
 *  * @create 2020-01-29 下午1:14
 *  * @last modify by [luoyong 2020-01-29 下午1:14]
 * @Description: Spring配置类
 **/
@Configuration
public class MainConfig {
    @Bean
    public Person person() {
        return new Person();
    }
}
