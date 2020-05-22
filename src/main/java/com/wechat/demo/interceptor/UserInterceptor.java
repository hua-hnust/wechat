package com.wechat.demo.interceptor;

import com.wechat.demo.constants.Errors;
import com.wechat.demo.mapper.UserMapper;
import com.wechat.demo.util.Exceptions;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 普通用户拦截器
 *
 * @Author xhua
 * @Date 2020/3/28 15:06
 **/
@Component
@Slf4j
public class UserInterceptor extends AbstractInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        // 是否免登录校验
        Boolean openApi = super.isOpenApi(handler);
        if (openApi) {
            return true;
        }else if (!doCheck(request, response,handler)) {
            Exceptions.throwss("当前登录用户没有操作权限");
        }
        return true;
    }

    /**
     * 鉴权逻辑
     *
     * @param request
     * @param response
     * @return
     */
    @Override
    protected boolean doCheck(HttpServletRequest request, HttpServletResponse response, Object handler) {

        if (SessionContext.getRemoteSid() == null) {
            Exceptions.throwss(Errors.INVALID_TOKEN);
        }
        if (!verifyToken()) {
            Exceptions.throwss(Errors.INVALID_TOKEN);
        }
        return true;
    }
}
