package com.cn.lx.vo;

import lombok.Data;

@Data
public class UserVO {
    private Integer id;
    private String name;
    private String gender;
    private String age;
    private String telephone;
    private String registerMode;
    private String thirdPartyId;
    private String password;

}
