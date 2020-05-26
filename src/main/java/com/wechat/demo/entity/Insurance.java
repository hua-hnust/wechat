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
 * @since 2020-05-26
 */
@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Insurance implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 缴纳月份202004
     */
      private Integer imonth;

      /**
     * 缴纳金额
     */
      private Double amount;

      /**
     * 类型（1、医保，2、养老，3、生育，4、失业，5、工伤）,
     */
      private Integer type;

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
