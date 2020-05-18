package com.wechat.demo.util;


import com.wechat.demo.constants.BizException;
import com.wechat.demo.constants.Errors;

public class Exceptions {

    public static void throwss(int code) {
        Exceptions.throwss(code, null);
    }

    public static void throwss(String msg) {
        Exceptions.throwss(-1, msg);
    }

    public static void throwss(Errors enums) {
        Exceptions.throwss(enums.getCode(), enums.getMessage());
    }

    public static void throwss(int code, String msg) {
        throw new BizException(code, msg);
    }
}

