package com.wechat.demo.constants;

import lombok.AllArgsConstructor;

/**
 * @Author xhua
 * @Date 2020/3/28 14:30
 **/
@AllArgsConstructor
public enum GuidanceType implements Enums{
    EDUCATION(1,"教育"),
    TRAFFIC(2,"交通"),
    SECURITY(3,"社保"),
    POOR(4,"困难家庭"),
    GRADUATE(5,"毕业生"),
    DISABILITY(6,"残疾人士");

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
