package com.cn.lx.dao;

import com.cn.lx.entity.Password;

public interface PasswordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Password record);

    int insertSelective(Password record);

    Password selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Password record);

    int updateByPrimaryKey(Password record);

    Password selectByUserId(Integer id);
}