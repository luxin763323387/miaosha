package com.cn.lx.controller;

import com.cn.lx.service.UserService;
import com.cn.lx.vo.ResponseVO;
import com.cn.lx.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@RestController
@RequestMapping(value = "/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    //获取手机验证码
    @RequestMapping(value = "getOtp",method = RequestMethod.GET)
    public ResponseVO getOtp(@RequestParam(name="telephone")String telephone){
        //按照一定规则生成验证码
        Random random = new Random();
        int randNum = random.nextInt(9999)+1000;
        String otp = ""+randNum;

        //根据session获取验证码
        httpServletRequest.getSession().setAttribute(otp,telephone);
        //将验证码发送给手机
        System.out.println("telephone："+telephone+" &otp： "+otp);
        return ResponseVO.success("发送成功");
    }

    /**
     * 通过id获取信息
     * @param id
     * @return
     */
    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public ResponseVO getUserInfo(@RequestParam(name = "id")Integer id){
        UserVO userVO = userService.getUserInfoById(id);
        if(userVO == null){
            return  ResponseVO.serviceFail("用户不存在");
        }else {
            return ResponseVO.success(userVO);
        }
    }
}
