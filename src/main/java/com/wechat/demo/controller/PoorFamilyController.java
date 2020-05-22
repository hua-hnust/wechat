package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.entity.PoorFamily;
import com.wechat.demo.entity.PoorFamily;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.PoorFamilyMapper;
import com.wechat.demo.mapper.PoorFamilyMapper;
import com.wechat.demo.service.PoorFamilyService;
import com.wechat.demo.service.PoorFamilyService;
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
@RequestMapping("/poorFamily")
public class PoorFamilyController {

    @Autowired
    private UserService userService;

    @Resource
    private PoorFamilyMapper poorFamilyMapper;

    @Autowired
    private PoorFamilyService poorFamilyService;

    @PostMapping("/addPoorFamily")
    @ResponseBody
    public void addPoorFamily(@RequestBody PoorFamily poorFamily) {
        PoorFamily oldEdu = new PoorFamily();
        User user = userService.currentUser();
        oldEdu.setId(null);
        oldEdu.setUserId(user.getId());
        oldEdu.setProvince(poorFamily.getProvince());
        oldEdu.setCity(poorFamily.getCity());
        oldEdu.setCounty(poorFamily.getCounty());
        oldEdu.setDetailAddress(poorFamily.getDetailAddress());
        oldEdu.setTitle(poorFamily.getTitle());
        oldEdu.setContent(poorFamily.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setCreateTime(LocalDateTime.now());
        oldEdu.setUpdateTime(LocalDateTime.now());
        poorFamilyService.save(oldEdu);
    }

    @PostMapping("/listPoorFamily")
    @ResponseBody
    public List<PoorFamily> listPoorFamily() {
        User user = userService.currentUser();
        PoorFamily build = PoorFamily.builder().userId(user.getId()).build();
        return poorFamilyMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getPoorFamily")
    @ResponseBody
    public PoorFamily getPoorFamily(@RequestParam("id") String id)  {
        return poorFamilyMapper.selectById(id);
    }

    @PostMapping("/editPoorFamily")
    @ResponseBody
    public void editPoorFamily(@RequestBody PoorFamily poorFamily)  {
        PoorFamily oldEdu = poorFamilyMapper.selectById(poorFamily.getId());
        oldEdu.setProvince(poorFamily.getProvince());
        oldEdu.setCity(poorFamily.getCity());
        oldEdu.setCounty(poorFamily.getCounty());
        oldEdu.setDetailAddress(poorFamily.getDetailAddress());
        oldEdu.setTitle(poorFamily.getTitle());
        oldEdu.setContent(poorFamily.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        poorFamilyService.updateById(oldEdu);
    }

    @PostMapping("/deletePoorFamily")
    @ResponseBody
    public void deletePoorFamily(@RequestBody PoorFamily poorFamily)  {
        PoorFamily oldEdu = poorFamilyMapper.selectById(poorFamily.getId());
        if (oldEdu != null){
            poorFamilyService.removeById(oldEdu.getId());
        }
    }
}

