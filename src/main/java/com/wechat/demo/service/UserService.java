package com.wechat.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

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

}