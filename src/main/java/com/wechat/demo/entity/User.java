package com.wechat.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.*;

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
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
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

      private String headImg;

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

}
