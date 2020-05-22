package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.assist.ISqlRunner;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.demo.interceptor.SessionContext;
import com.wechat.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User>   {

    @Resource
    private UserMapper userMapper;

    public User currentUser() {
        User query = new User();
        query.setToken(SessionContext.getRemoteSid());
        return userMapper.selectOne(new QueryWrapper<>(query).gt("token_expire_time", LocalDateTime.now()));
    }

    public User getByOpenId(String openId) {
        User query = new User();
        query.setOpenid(openId);
        return userMapper.selectOne(new QueryWrapper<>(query));
    }
}
