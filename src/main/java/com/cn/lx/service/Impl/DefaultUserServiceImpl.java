package com.cn.lx.service.Impl;

import com.cn.lx.dao.PasswordMapper;
import com.cn.lx.dao.UserMapper;
import com.cn.lx.entity.Password;
import com.cn.lx.entity.User;
import com.cn.lx.service.UserService;
import com.cn.lx.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class DefaultUserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordMapper passwordMapper;


    private UserVO do2UserVO (User user, Password password){
        UserVO userVO = new UserVO();
        if(user == null){
            return null;
        }
        userVO.setThirdPartyId(user.getThirdPartyId());
        userVO.setTelephone(user.getTelephone());
        userVO.setRegisterMode(user.getRegisterMode());
        userVO.setName(user.getName());
        userVO.setId(user.getId());
        userVO.setGender(""+user.getGender());
        userVO.setAge(""+user.getAge());
        if(password == null){
            return null;
        }
        userVO.setPassword(password.getPassword());
        return userVO;
    }

    //获取用户信息
    @Override
    public UserVO getUserInfoById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        if(user == null){
            return null;
        }
        Password password = passwordMapper.selectByUserId(id);
        UserVO userVO = do2UserVO(user, password);
        return userVO;
    }
}
