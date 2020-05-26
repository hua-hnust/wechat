package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.dto.req.BusinessFilter;
import com.wechat.demo.entity.Insurance;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.InsuranceMapper;
import com.wechat.demo.service.InsuranceService;
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
 * @since 2020-05-26
 */
@RestController
@RequestMapping("/insurance")
public class InsuranceController {



    @Autowired
    private UserService userService;

    @Resource
    private InsuranceMapper insuranceMapper;

    @Autowired
    private InsuranceService insuranceService;

    @PostMapping("/addInsurance")
    @ResponseBody
    public void addInsurance(@RequestBody Insurance insurance) {
        Insurance oldEdu = new Insurance();
        User user = userService.currentUser();
        oldEdu.setId(null);
        oldEdu.setUserId(user.getId());
        oldEdu.setType(insurance.getType());
        oldEdu.setImonth(insurance.getImonth());
        oldEdu.setAmount(insurance.getAmount());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setCreateTime(LocalDateTime.now());
        oldEdu.setUpdateTime(LocalDateTime.now());
        insuranceService.save(oldEdu);
    }

    @PostMapping("/listInsurance")
    @ResponseBody
    public List<Insurance> listInsurance() {
        User user = userService.currentUser();
        Insurance build = Insurance.builder().userId(user.getId()).build();
        return insuranceMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getInsurance")
    @ResponseBody
    public Insurance getInsurance(@RequestParam("id") String id)  {
        return insuranceMapper.selectById(id);
    }

    @PostMapping("/editInsurance")
    @ResponseBody
    public void editInsurance(@RequestBody Insurance insurance)  {
        Insurance oldEdu = insuranceMapper.selectById(insurance.getId());
        oldEdu.setType(insurance.getType());
        oldEdu.setImonth(insurance.getImonth());
        oldEdu.setAmount(insurance.getAmount());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        insuranceService.updateById(oldEdu);
    }

    @PostMapping("/deleteInsurance")
    @ResponseBody
    public void deleteInsurance(@RequestBody Insurance insurance)  {
        Insurance oldEdu = insuranceMapper.selectById(insurance.getId());
        if (oldEdu != null){
            insuranceService.removeById(oldEdu.getId());
        }
    }


    @PostMapping("/admin/list")
    public IPage<Insurance> getAdminList(@RequestBody BusinessFilter filter)  {
        return insuranceService.selectList(filter.getPage(),filter.getLimit(),filter.getType(),filter.getStatus());
    }

    @PostMapping("/admin/edit")
    public void editAdminData(@RequestBody Insurance insurance)  {
        Insurance oldData = insuranceMapper.selectById(insurance.getId());
        oldData.setStatus(insurance.getStatus());
        oldData.setReply(insurance.getReply());
        oldData.setUpdateTime(LocalDateTime.now());
        insuranceService.updateById(oldData);
    }
}

