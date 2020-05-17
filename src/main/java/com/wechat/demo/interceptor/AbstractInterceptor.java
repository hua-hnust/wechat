package com.wechat.demo.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wechat.demo.annotation.OpenApi;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.UserMapper;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author xhua
 * @Date 2020/3/22 12:29
 **/
public abstract class AbstractInterceptor implements HandlerInterceptor {


    @Resource
    private UserMapper userMapper;

    private static final ObjectMapper objectMapper = new ObjectMapper();

    /** 鉴权方法，由子类实现 **/
    protected abstract boolean doCheck(HttpServletRequest request, HttpServletResponse response,Object handler);

    /**
     *  免登录
     * @param handler
     * @return
     */
    protected Boolean isOpenApi(Object handler){
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod)handler;
            Method method = handlerMethod.getMethod();
            if (method.getAnnotation(OpenApi.class) != null){
                return true;
            }else if (method.getDeclaringClass().getAnnotation(OpenApi.class) != null){
                return true;
            }
        }
        return false;
    }

    /**
     *  验证token是否有效
     * @return
     */
    protected boolean verifyToken(){
        String token = SessionContext.getRemoteSid();
        User query = new User();
        query.setToken(token);
        User user = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isNotEmpty(user) && user.getTokenExpireTime().isAfter(LocalDateTime.now())){
            //验证成功后刷新缓存时间
            user.setTokenExpireTime(LocalDateTime.now().plusHours(2));
            userMapper.updateById(user);
            return true;
        }

        return false;
    }

}
