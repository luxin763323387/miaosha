package com.cn.lx.controller;

import com.cn.lx.service.UserService;
import com.cn.lx.vo.ResponseVO;
import com.cn.lx.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user/")
public class UserController {


    @Autowired
    private UserService userService;


    //通过id获取信息
    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public ResponseVO getUserInfo(@RequestParam(name = "id")Integer id){
        UserVO userVO = userService.getUserInfoById(id);
        return ResponseVO.success(userVO);
    }
}
