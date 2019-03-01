package com.example.controllor;

import com.example.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 3:54 PM 2019/2/28
 */
@RestController
public class UserControllor {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllor.class);

    @GetMapping("/getUser")
    public UserInfoVO getUserById(){
        LOGGER.info("query user id {} ",1);
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setId("2");
        userInfoVO.setName("张三");
        userInfoVO.setAge(20);
        userInfoVO.setBirth(new Date());
        return userInfoVO;
    }
}
