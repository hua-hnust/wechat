package com.wechat.demo.constants;

import lombok.AllArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/28 14:30
 **/
@AllArgsConstructor
public enum InsuranceType implements Enums{
    HOSPITAL(1,"医保"),
    OLD(2,"养老"),
    BABY(3,"生育"),
    WORK(4,"失业"),
    HURT(5,"工伤");

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
