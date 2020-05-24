package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.entity.Notice;
import com.wechat.demo.mapper.NoticeMapper;
import com.wechat.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {


    @Autowired
    private NoticeMapper noticeMapper;

    @Resource
    private NoticeService noticeService;

    @PostMapping("/addNotice")
    @ResponseBody
    public void addNotice(@RequestBody Notice notice) {
        Notice newNotice = new Notice();
        newNotice.setId(null);
        newNotice.setDepartment(notice.getDepartment());
        newNotice.setTitle(notice.getTitle());
        newNotice.setContent(notice.getContent());
        newNotice.setCreateTime(LocalDateTime.now());
        newNotice.setUpdateTime(LocalDateTime.now());
        noticeService.save(newNotice);
    }

    @PostMapping("/listNotice")
    @ResponseBody
    public List<Notice> listNotice() {
        Notice build = Notice.builder().build();
        return noticeMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getNotice")
    @ResponseBody
    public Notice getNotice(@RequestParam("id") String id)  {
        return noticeMapper.selectById(id);
    }

    @PostMapping("/editNotice")
    @ResponseBody
    public void editNotice(@RequestBody Notice notice)  {
        Notice oldEdu = noticeMapper.selectById(notice.getId());
        oldEdu.setDepartment(notice.getDepartment());
        oldEdu.setTitle(notice.getTitle());
        oldEdu.setContent(notice.getContent());
        oldEdu.setUpdateTime(LocalDateTime.now());
        noticeService.updateById(oldEdu);
    }

    @PostMapping("/deleteNotice")
    @ResponseBody
    public void deleteNotice(@RequestBody Notice notice)  {
        Notice oldEdu = noticeMapper.selectById(notice.getId());
        if (oldEdu != null){
            noticeService.removeById(oldEdu.getId());
        }
    }
}

