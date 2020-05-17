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
public class PoorFamily implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 省
     */
      private String province;

      /**
     * 市
     */
      private String city;

      /**
     * 县、区
     */
      private String county;

      /**
     * 详细地址
     */
      private String detailAddress;

      /**
     * 标题
     */
      private String title;

      /**
     * 内容
     */
      private String content;

      /**
     * 回复内容
     */
      private String reply;

      /**
     * 状态：0 待处理，1 处理中，2 处理完成
     */
      private Integer status;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      private LocalDateTime updateTime;

}
