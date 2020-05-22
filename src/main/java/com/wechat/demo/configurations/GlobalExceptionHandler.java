package com.wechat.demo.configurations;

import com.wechat.demo.constants.BizException;
import com.wechat.demo.constants.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(BizException.class)
    public Result globalException(HttpServletResponse response, BizException bizException){
        //业务报错进行统一处理

        return Result.error(bizException.getCode(),bizException.getMessage());
    }

}