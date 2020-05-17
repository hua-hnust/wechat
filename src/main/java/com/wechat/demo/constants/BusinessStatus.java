package com.wechat.demo.constants;

import lombok.AllArgsConstructor;

/**
 * 业务处理状态
 * @Author xhua
 * @Date 2020/3/28 14:30
 **/

@AllArgsConstructor
public enum BusinessStatus implements Enums{

    WAIT(0,"待处理"),
    WORKING(1,"处理中"),
    FINISH(2,"处理完成"),
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
