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
public class Graduate implements Serializable {

    private static final long serialVersionUID=1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

      /**
     * 用户id
     */
      private Integer userId;

      /**
     * 学校
     */
      private String school;

      /**
     * 学年
     */
      private Integer schoolYear;

      /**
     * 专业
     */
      private String major;

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

    
    public Integer getId() {
        return id;
    }

      public void setId(Integer id) {
          this.id = id;
      }
    
    public Integer getUserId() {
        return userId;
    }

      public void setUserId(Integer userId) {
          this.userId = userId;
      }
    
    public String getSchool() {
        return school;
    }

      public void setSchool(String school) {
          this.school = school;
      }
    
    public Integer getSchoolYear() {
        return schoolYear;
    }

      public void setSchoolYear(Integer schoolYear) {
          this.schoolYear = schoolYear;
      }
    
    public String getMajor() {
        return major;
    }

      public void setMajor(String major) {
          this.major = major;
      }
    
    public String getTitle() {
        return title;
    }

      public void setTitle(String title) {
          this.title = title;
      }
    
    public String getContent() {
        return content;
    }

      public void setContent(String content) {
          this.content = content;
      }
    
    public String getReply() {
        return reply;
    }

      public void setReply(String reply) {
          this.reply = reply;
      }
    
    public Integer getStatus() {
        return status;
    }

      public void setStatus(Integer status) {
          this.status = status;
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
        return "Graduate{" +
              "id=" + id +
                  ", userId=" + userId +
                  ", school=" + school +
                  ", schoolYear=" + schoolYear +
                  ", major=" + major +
                  ", title=" + title +
                  ", content=" + content +
                  ", reply=" + reply +
                  ", status=" + status +
                  ", createTime=" + createTime +
                  ", updateTime=" + updateTime +
              "}";
    }
}
