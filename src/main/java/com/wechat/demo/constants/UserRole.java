package com.wechat.demo.constants;

import lombok.AllArgsConstructor;

/**
 * 业务处理状态
 * @Author xhua
 * @Date 2020/3/28 14:30
 **/

@AllArgsConstructor
public enum UserRole implements Enums{

    USER(0,"普通用户"),
    ADMIN(1,"管理员"),
    ;

    private int code;
    private String desc;

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }


}
