package com.wechat.demo.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/** 公众号配置
 * @Author xhua
 * @Date 2020/5/8 11:38
 **/
@Configuration
@Data
@ConfigurationProperties(prefix = "wechat")
public class WechatConfig {

    /** 公众号 appid **/
    private String appId;
    /** 公众号 appSecret **/
    private String appSecret;
    private String secretKey;

}
