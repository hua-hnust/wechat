package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.entity.Education;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.EducationMapper;
import com.wechat.demo.service.EducationService;
import com.wechat.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@Controller
@RequestMapping("/education")
public class EducationController {

    @Autowired
    private UserService userService;
    @Autowired
    private EducationMapper educationMapper;

    @Autowired
    private EducationService educationService;

    @PostMapping("/addEducation")
    @ResponseBody
    public void addEducation(@RequestBody Education education) {
        Education newEducation = new Education();
        User user = userService.currentUser();
        newEducation.setId(null);
        newEducation.setUserId(user.getId());
        newEducation.setSchool(education.getSchool());
        newEducation.setSchoolYear(education.getSchoolYear());
        newEducation.setMajor(education.getMajor());
        newEducation.setTitle(education.getTitle());
        newEducation.setContent(education.getContent());
        newEducation.setStatus(BusinessStatus.WAIT.getCode());
        newEducation.setCreateTime(LocalDateTime.now());
        newEducation.setUpdateTime(LocalDateTime.now());
        educationService.save(newEducation);
    }

    @PostMapping("/listEducation")
    @ResponseBody
    public List<Education> listEducation() {
        User user = userService.currentUser();
        Education build = Education.builder().userId(user.getId()).build();
        return educationMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getEducation")
    @ResponseBody
    public Education getEducation(@RequestParam("id") String id)  {
        return educationMapper.selectById(id);
    }

    @PostMapping("/editEducation")
    @ResponseBody
    public void editEducation(@RequestBody Education education)  {
        Education oldEdu = educationMapper.selectById(education.getId());
        oldEdu.setSchool(education.getSchool());
        oldEdu.setSchoolYear(education.getSchoolYear());
        oldEdu.setMajor(education.getMajor());
        oldEdu.setTitle(education.getTitle());
        oldEdu.setContent(education.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        educationService.updateById(oldEdu);
    }

    @PostMapping("/deleteEducation")
    @ResponseBody
    public void deleteEducation(@RequestBody Education education)  {
        Education oldEdu = educationMapper.selectById(education.getId());
        if (oldEdu != null){
            educationService.removeById(oldEdu.getId());
        }
    }

}

