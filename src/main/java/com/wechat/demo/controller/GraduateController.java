package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.entity.Graduate;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.GraduateMapper;
import com.wechat.demo.service.GraduateService;
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
@RequestMapping("/graduate")
public class GraduateController {


    @Autowired
    private UserService userService;

    @Resource
    private GraduateMapper graduateMapper;

    @Autowired
    private GraduateService graduateService;

    @PostMapping("/addGraduate")
    @ResponseBody
    public void addGraduate(@RequestBody Graduate graduate) {
        Graduate newGraduate = new Graduate();
        User user = userService.currentUser();
        newGraduate.setId(null);
        newGraduate.setUserId(user.getId());
        newGraduate.setSchool(graduate.getSchool());
        newGraduate.setSchoolYear(graduate.getSchoolYear());
        newGraduate.setMajor(graduate.getMajor());
        newGraduate.setTitle(graduate.getTitle());
        newGraduate.setContent(graduate.getContent());
        newGraduate.setStatus(BusinessStatus.WAIT.getCode());
        newGraduate.setCreateTime(LocalDateTime.now());
        newGraduate.setUpdateTime(LocalDateTime.now());
        graduateService.save(newGraduate);
    }

    @PostMapping("/listGraduate")
    @ResponseBody
    public List<Graduate> listGraduate() {
        User user = userService.currentUser();
        Graduate build = Graduate.builder().userId(user.getId()).build();
        return graduateMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getGraduate")
    @ResponseBody
    public Graduate getGraduate(@RequestParam("id") String id)  {
        return graduateMapper.selectById(id);
    }

    @PostMapping("/editGraduate")
    @ResponseBody
    public void editGraduate(@RequestBody Graduate graduate)  {
        Graduate oldEdu = graduateMapper.selectById(graduate.getId());
        oldEdu.setSchool(graduate.getSchool());
        oldEdu.setSchoolYear(graduate.getSchoolYear());
        oldEdu.setMajor(graduate.getMajor());
        oldEdu.setTitle(graduate.getTitle());
        oldEdu.setContent(graduate.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        graduateService.updateById(oldEdu);
    }

    @PostMapping("/deleteGraduate")
    @ResponseBody
    public void deleteGraduate(@RequestBody Graduate graduate)  {
        Graduate oldEdu = graduateMapper.selectById(graduate.getId());
        if (oldEdu != null){
            graduateService.removeById(oldEdu.getId());
        }
    }
}

