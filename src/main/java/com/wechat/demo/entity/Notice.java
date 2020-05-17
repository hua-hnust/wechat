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
public class Notice implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 部门
     */
      private String department;

      /**
     * 标题
     */
      private String title;

      /**
     * 内容
     */
      private String content;

      /**
     * 创建时间
     */
      private LocalDateTime createTime;

      /**
     * 更新时间
     */
      private LocalDateTime updateTime;


}
