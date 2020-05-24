package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.wechat.demo.constants.Enums;
import com.wechat.demo.constants.UserRole;
import com.wechat.demo.dto.req.RegisterDTO;
import com.wechat.demo.dto.rsp.UserInfo;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.UserMapper;
import com.wechat.demo.util.Exceptions;
import com.wechat.demo.util.MD5Util;
import com.wechat.demo.util.RegexUtil;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * @Author xhua
 * @Date 2020/3/24 16:03
 **/
@Service
public class AuthService {

    @Resource
    private UserMapper userMapper;

    /**
     * 验证登录、创建token，更新会话过期时间
     *
     * @param phone
     * @param password
     * @return
     */
    public UserInfo verifyPhoneAndPassword(String phone, String password) {

        if (!RegexUtil.regexPhone(phone)) {
            Exceptions.throwss("手机号格式错误");
        }

        if (StringUtils.isEmpty(phone) || StringUtils.isEmpty(password)) {
            Exceptions.throwss("请输入账号密码");
        }
        //加密密码
        String encryptStr = MD5Util.encrypt(password);
        User query = new User();
        query.setPhone(phone);
        //检查账户是否存在
        User user = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isEmpty(user)) {
            Exceptions.throwss("用户不存在");
        }

        User query1 = new User();
        query1.setPhone(phone);
        query1.setPassword(encryptStr);
        User user1 = userMapper.selectOne(new QueryWrapper<>(query1));
        if (ObjectUtils.isEmpty(user1)) {
            Exceptions.throwss("密码错误");
        }
        String token = UUID.randomUUID().toString();
        user1.setToken(token);
        user1.setTokenExpireTime(LocalDateTime.now().plusHours(2));
        userMapper.updateById(user1);

        UserRole userRole = Enums.valueOf(user1.getUserType(), UserRole.class);
        return UserInfo.builder()
                .token(token)
                .name(user1.getName())
                .headImg(user1.getHeadImg())
                .role(userRole == null ? "未知" : userRole.getDesc()).build();

    }

    /**
     * 注册逻辑
     *
     * @param registerDTO
     * @return
     */
    public boolean register(RegisterDTO registerDTO) {

        if (!RegexUtil.regexPhone(registerDTO.getPhone())) {
            Exceptions.throwss("手机号格式错误");
        }
        User query = User.builder().phone(registerDTO.getPhone()).build();
        User existUser = userMapper.selectOne(new QueryWrapper<>(query));
        if (ObjectUtils.isNotEmpty(existUser)){
            Exceptions.throwss("号码已注册");
        }
        User user = User.builder().
                name(registerDTO.getName()).
                password(MD5Util.encrypt(registerDTO.getPassword())).
                phone(registerDTO.getPhone()).
                userType(UserRole.ADMIN.getCode()).
                createTime(LocalDateTime.now()).
                build();
        int res = userMapper.insert(user);
        return res > 0 ;
    }

}
