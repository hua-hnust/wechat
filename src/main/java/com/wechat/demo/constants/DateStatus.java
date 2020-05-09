package com.wechat.demo.constants;

import lombok.AllArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/28 14:30
 **/
@AllArgsConstructor
public enum DateStatus implements Enums{

    VALID(1,"有效的"),
    INVALID(0,"无效的");

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
