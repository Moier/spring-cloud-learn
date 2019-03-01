package com.example.controllor;

import com.example.service.UserService;
import com.example.vo.UserInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 9:51 AM 2019/3/1
 */
@RestController
public class UserControllor {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserControllor.class);

    @Autowired
    private UserService userService;


    @GetMapping("/getUser")
    public String getUser(HttpServletRequest request){
        Enumeration headerNames = request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String key =(String) headerNames.nextElement();
            LOGGER.info(key," : ",request.getHeader(key));
        }
        return "hello world";
    }

    @GetMapping("/getUserEntity")
    public UserInfoVO getUserEntity(){
        return userService.getUserInfo();
    }
}
