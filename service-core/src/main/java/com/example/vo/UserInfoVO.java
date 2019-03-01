package com.example.vo;

import java.util.Date;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 3:55 PM 2019/2/28
 */

public class UserInfoVO {

    private String id;
    private String name;
    private Integer age;
    private Date birth;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
