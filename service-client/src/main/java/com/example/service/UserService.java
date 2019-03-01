package com.example.service;

import com.example.vo.UserInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author: huanghs
 * @Date: Created in 5:25 PM 2019/2/28
 */

@FeignClient("service-core")
public interface UserService {


    @RequestMapping(method = RequestMethod.GET,value = "/api/getUser")
    public UserInfoVO getUserInfo();

}
