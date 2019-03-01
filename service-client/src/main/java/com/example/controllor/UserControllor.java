package com.example.controllor;

import com.example.service.UserService;
import com.example.vo.UserInfoVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 9:51 AM 2019/3/1
 */
@RestController
public class UserControllor {


    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public UserInfoVO getUser(){
        return userService.getUserInfo();
    }
}
