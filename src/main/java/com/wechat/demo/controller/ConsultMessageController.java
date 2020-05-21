package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.entity.ConsultMessage;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.ConsultMessageMapper;
import com.wechat.demo.service.ConsultMessageService;
import com.wechat.demo.service.UserService;
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
@Controller
@RequestMapping("/consultMessage")
public class ConsultMessageController {
    @Autowired
    private UserService userService;

    @Resource
    private ConsultMessageMapper consultMessageMapper;

    @Autowired
    private ConsultMessageService consultMessageService;

    @PostMapping("/addConsultMessage")
    @ResponseBody
    public void addConsultMessage(@RequestBody ConsultMessage consultMessage) {
        ConsultMessage oldEdu = new ConsultMessage();
        User user = userService.currentUser();
        oldEdu.setId(null);
        oldEdu.setUserId(user.getId());
        oldEdu.setTitle(consultMessage.getTitle());
        oldEdu.setContent(consultMessage.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setCreateTime(LocalDateTime.now());
        oldEdu.setUpdateTime(LocalDateTime.now());
        consultMessageService.save(oldEdu);
    }

    @PostMapping("/listConsultMessage")
    @ResponseBody
    public List<ConsultMessage> listConsultMessage() {
        User user = userService.currentUser();
        ConsultMessage build = ConsultMessage.builder().userId(user.getId()).build();
        return consultMessageMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getConsultMessage")
    @ResponseBody
    public ConsultMessage getConsultMessage(@RequestParam("id") String id)  {
        return consultMessageMapper.selectById(id);
    }

    @PostMapping("/editConsultMessage")
    @ResponseBody
    public void editConsultMessage(@RequestBody ConsultMessage consultMessage)  {
        ConsultMessage oldEdu = consultMessageMapper.selectById(consultMessage.getId());
        oldEdu.setTitle(consultMessage.getTitle());
        oldEdu.setContent(consultMessage.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        consultMessageService.updateById(oldEdu);
    }

    @PostMapping("/deleteConsultMessage")
    @ResponseBody
    public void deleteConsultMessage(@RequestBody ConsultMessage consultMessage)  {
        ConsultMessage oldEdu = consultMessageMapper.selectById(consultMessage.getId());
        if (oldEdu != null){
            consultMessageService.removeById(oldEdu.getId());
        }
    }
}

