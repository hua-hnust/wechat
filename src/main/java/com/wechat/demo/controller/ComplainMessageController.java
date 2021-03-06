package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.dto.req.BusinessFilter;
import com.wechat.demo.entity.ComplainMessage;
import com.wechat.demo.entity.ComplainMessage;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.ComplainMessageMapper;
import com.wechat.demo.service.ComplainMessageService;
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
@RestController
@RequestMapping("/complainMessage")
public class ComplainMessageController {
    @Autowired
    private UserService userService;

    @Resource
    private ComplainMessageMapper complainMessageMapper;

    @Autowired
    private ComplainMessageService complainMessageService;

    @PostMapping("/addComplainMessage")
    @ResponseBody
    public void addComplainMessage(@RequestBody ComplainMessage complainMessage) {
        ComplainMessage oldEdu = new ComplainMessage();
        User user = userService.currentUser();
        oldEdu.setId(null);
        oldEdu.setUserId(user.getId());
        oldEdu.setTitle(complainMessage.getTitle());
        oldEdu.setContent(complainMessage.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setCreateTime(LocalDateTime.now());
        oldEdu.setUpdateTime(LocalDateTime.now());
        complainMessageService.save(oldEdu);
    }

    @PostMapping("/listComplainMessage")
    @ResponseBody
    public List<ComplainMessage> listComplainMessage() {
        User user = userService.currentUser();
        ComplainMessage build = ComplainMessage.builder().userId(user.getId()).build();
        return complainMessageMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getComplainMessage")
    @ResponseBody
    public ComplainMessage getComplainMessage(@RequestParam("id") String id)  {
        return complainMessageMapper.selectById(id);
    }

    @PostMapping("/editComplainMessage")
    @ResponseBody
    public void editComplainMessage(@RequestBody ComplainMessage complainMessage)  {
        ComplainMessage oldEdu = complainMessageMapper.selectById(complainMessage.getId());
        oldEdu.setTitle(complainMessage.getTitle());
        oldEdu.setContent(complainMessage.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        complainMessageService.updateById(oldEdu);
    }

    @PostMapping("/deleteComplainMessage")
    @ResponseBody
    public void deleteComplainMessage(@RequestBody ComplainMessage complainMessage)  {
        ComplainMessage oldEdu = complainMessageMapper.selectById(complainMessage.getId());
        if (oldEdu != null){
            complainMessageService.removeById(oldEdu.getId());
        }
    }

    @PostMapping("/admin/list")
    public IPage<ComplainMessage> getAdminList(@RequestBody BusinessFilter filter)  {
        return complainMessageService.getAdminList(filter.getPage(),filter.getLimit(),filter.getStatus());
    }

    @PostMapping("/admin/edit")
    public void editAdminData(@RequestBody ComplainMessage traffic)  {
        ComplainMessage oldData = complainMessageMapper.selectById(traffic.getId());
        oldData.setStatus(traffic.getStatus());
        oldData.setReply(traffic.getReply());
        oldData.setUpdateTime(LocalDateTime.now());
        complainMessageService.updateById(oldData);
    }
}

