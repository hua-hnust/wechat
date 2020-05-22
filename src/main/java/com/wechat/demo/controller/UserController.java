package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wechat.demo.annotation.OpenApi;
import com.wechat.demo.constants.CommonConstants;
import com.wechat.demo.constants.Enums;
import com.wechat.demo.constants.UserRole;
import com.wechat.demo.dto.req.LoginParam;
import com.wechat.demo.dto.req.RegisterDTO;
import com.wechat.demo.dto.rsp.LoginInfoDTO;
import com.wechat.demo.dto.rsp.UserInfo;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.UserMapper;
import com.wechat.demo.service.AuthService;
import com.wechat.demo.service.UserService;
import com.wechat.demo.util.DateTimeUtil;
import com.wechat.demo.util.WechatAuthHelper;
import com.wechat.demo.util.WechatBaseInfo;
import com.wechat.demo.util.WechatH5AccessToken;
import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.security.InvalidParameterException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import static com.wechat.demo.constants.Errors.INVALID_TOKEN;
import static com.wechat.demo.constants.Errors.of;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;

    @Resource
    private UserMapper userMapper;

    @Value("${wechat.appId}")
    private String appId;

    @Value("${wechat.secretKey}")
    private String secretKey;

    @Autowired
    private AuthService authService;


    @OpenApi
    @PostMapping("/wechat/login")
    public UserInfo wechatLogin(@RequestBody LoginParam param){

        String code = param.getCode();
        if(StringUtils.isBlank(code)){
            throw new InvalidParameterException();
        }
        UserInfo userInfo = new UserInfo();
        //检查code是否已存在
        User user = User.builder().wechatCode(code).build();
        User existedUser = userMapper.selectOne(new QueryWrapper<>(user));
        if (existedUser != null){
            LocalDateTime tokenExpireTime = existedUser.getTokenExpireTime();
            if (tokenExpireTime.isAfter(LocalDateTime.now())){
                userInfo.setName(existedUser.getName());
                userInfo.setRole(Enums.valueOf(existedUser.getUserType(), UserRole.class).getDesc());
                userInfo.setToken(existedUser.getToken());
                userInfo.setHeadImg(existedUser.getHeadImg());
                return userInfo;
            }
        }
        //获取用户信息
        WechatH5AccessToken wechatH5AccessToken = WechatAuthHelper.getWechatH5AccessToken(appId, secretKey, code);
        String openId = wechatH5AccessToken.getOpenId();
        String accessToken = wechatH5AccessToken.getAccessToken();
        user = User.builder().openid(openId).build();
        existedUser = userMapper.selectOne(new QueryWrapper<>(user));
        if (existedUser != null){
            existedUser.setTokenExpireTime(LocalDateTime.now().plusHours(2));
            userMapper.updateById(existedUser);
            userInfo.setName(existedUser.getName());
            userInfo.setRole(Enums.valueOf(existedUser.getUserType(), UserRole.class).getDesc());
            userInfo.setToken(existedUser.getToken());
            userInfo.setHeadImg(existedUser.getHeadImg());
            return userInfo;
        }

        WechatBaseInfo wechatBaseInfo = WechatAuthHelper.getGzhH5UserInfo(accessToken, openId);
        User newUser =  new User();
        newUser.setUserType(UserRole.USER.getCode());
        newUser.setOpenid(openId);
        newUser.setWechatCode(code);
        newUser.setName(wechatBaseInfo.getNickname());
        String token = UUID.randomUUID().toString();
        newUser.setHeadImg(wechatBaseInfo.getHeadimgurl());

        newUser.setToken(token);

        newUser.setTokenExpireTime(LocalDateTime.now().plusHours(2));
        newUser.setCreateTime(LocalDateTime.now());
        newUser.setUpdateTime(LocalDateTime.now());
        //保存到数据库
        userMapper.insert(newUser);


        // 下发登录token
        userInfo.setName(newUser.getName());
        userInfo.setRole(Enums.valueOf(newUser.getUserType(), UserRole.class).getDesc());
        userInfo.setToken(newUser.getToken());
        userInfo.setHeadImg(newUser.getHeadImg());
        return userInfo;
    }
    /**
     *  登录接口
     * @param param
     * @return
     */
    @PostMapping("/login")
    @OpenApi
    public UserInfo login(@RequestBody LoginParam param){
        return authService.verifyPhoneAndPassword(param.getPhone(), param.getPassword());
    }

    /**
     *  注册接口
     * @param registerDTO
     * @return
     */
    @PostMapping("/register")
    @OpenApi
    public Boolean register(@RequestBody RegisterDTO registerDTO){
        return authService.register(registerDTO);
    }



    /**
     *  注册接口
     * @param
     * @return
     */
    @GetMapping("/info")
    public UserInfo register(){
        User user = userService.currentUser();
        UserRole userRole = Enums.valueOf(user.getUserType(), UserRole.class);
        UserInfo userInfo = new UserInfo();
        userInfo.setToken(user.getToken());
        userInfo.setName(user.getName());
        userInfo.setRole(userRole == null ? "未知" : userRole.getDesc());
        userInfo.setHeadImg(user.getHeadImg());
        return userInfo;
    }

    /**
     *  退出登录
     * @return
     */
    @PostMapping("logout")
    public Boolean logout(){
        User currentUser = Optional.ofNullable(userService.currentUser()).orElseThrow(() -> of(INVALID_TOKEN));
        currentUser.setTokenExpireTime(LocalDateTime.now());
        return userService.updateById(currentUser);
    }


}

