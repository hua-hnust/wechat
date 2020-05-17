package com.wechat.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
public class User implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户类型 0 用户，1 管理员
     */
      private Integer userType;

      /**
     * 微信openid
     */
      private String openid;

      /**
     * 微信code,获取用户信息的code
     */
      private String wechatCode;

      /**
     * 手机号码
     */
      private String phone;

      /**
     * 邮箱
     */
      private String email;

      /**
     * 名称
     */
      private String name;

      /**
     * 密码
     */
      private String password;

      /**
     * 登录token
     */
      private String token;

      /**
     * token过期时间
     */
      private LocalDateTime tokenExpireTime;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      private LocalDateTime updateTime;

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public Integer getUserType() {
        return userType;
    }

      public void setUserType(Integer userType) {
          this.userType = userType;
      }
    
    public String getOpenid() {
        return openid;
    }

      public void setOpenid(String openid) {
          this.openid = openid;
      }
    
    public String getWechatCode() {
        return wechatCode;
    }

      public void setWechatCode(String wechatCode) {
          this.wechatCode = wechatCode;
      }
    
    public String getPhone() {
        return phone;
    }

      public void setPhone(String phone) {
          this.phone = phone;
      }
    
    public String getEmail() {
        return email;
    }

      public void setEmail(String email) {
          this.email = email;
      }
    
    public String getName() {
        return name;
    }

      public void setName(String name) {
          this.name = name;
      }
    
    public String getPassword() {
        return password;
    }

      public void setPassword(String password) {
          this.password = password;
      }
    
    public String getToken() {
        return token;
    }

      public void setToken(String token) {
          this.token = token;
      }
    
    public LocalDateTime getTokenExpireTime() {
        return tokenExpireTime;
    }

      public void setTokenExpireTime(LocalDateTime tokenExpireTime) {
          this.tokenExpireTime = tokenExpireTime;
      }
    
    public LocalDateTime getCreateTime() {
        return createTime;
    }

      public void setCreateTime(LocalDateTime createTime) {
          this.createTime = createTime;
      }
    
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

      public void setUpdateTime(LocalDateTime updateTime) {
          this.updateTime = updateTime;
      }

    @Override
    public String toString() {
        return "User{" +
              "id=" + id +
                  ", userType=" + userType +
                  ", openid=" + openid +
                  ", wechatCode=" + wechatCode +
                  ", phone=" + phone +
                  ", email=" + email +
                  ", name=" + name +
                  ", password=" + password +
                  ", token=" + token +
                  ", tokenExpireTime=" + tokenExpireTime +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
