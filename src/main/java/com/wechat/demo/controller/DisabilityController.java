package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.dto.req.BusinessFilter;
import com.wechat.demo.entity.Disability;
import com.wechat.demo.entity.PoorFamily;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.DisabilityMapper;
import com.wechat.demo.service.DisabilityService;
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
@RequestMapping("/disability")
public class DisabilityController {
    @Autowired
    private UserService userService;

    @Resource
    private DisabilityMapper disabilityMapper;

    @Autowired
    private DisabilityService disabilityService;

    @PostMapping("/addDisability")
    @ResponseBody
    public void addDisability(@RequestBody Disability disability) {
        Disability oldEdu = new Disability();
        User user = userService.currentUser();
        oldEdu.setId(null);
        oldEdu.setUserId(user.getId());
        oldEdu.setProvince(disability.getProvince());
        oldEdu.setCity(disability.getCity());
        oldEdu.setCounty(disability.getCounty());
        oldEdu.setDetailAddress(disability.getDetailAddress());
        oldEdu.setTitle(disability.getTitle());
        oldEdu.setContent(disability.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setCreateTime(LocalDateTime.now());
        oldEdu.setUpdateTime(LocalDateTime.now());
        disabilityService.save(oldEdu);
    }

    @PostMapping("/listDisability")
    @ResponseBody
    public List<Disability> listDisability() {
        User user = userService.currentUser();
        Disability build = Disability.builder().userId(user.getId()).build();
        return disabilityMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getDisability")
    @ResponseBody
    public Disability getDisability(@RequestParam("id") String id)  {
        return disabilityMapper.selectById(id);
    }

    @PostMapping("/editDisability")
    @ResponseBody
    public void editDisability(@RequestBody Disability disability)  {
        Disability oldEdu = disabilityMapper.selectById(disability.getId());
        oldEdu.setProvince(disability.getProvince());
        oldEdu.setCity(disability.getCity());
        oldEdu.setCounty(disability.getCounty());
        oldEdu.setDetailAddress(disability.getDetailAddress());
        oldEdu.setTitle(disability.getTitle());
        oldEdu.setContent(disability.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        disabilityService.updateById(oldEdu);
    }

    @PostMapping("/deleteDisability")
    @ResponseBody
    public void deleteDisability(@RequestBody Disability disability)  {
        Disability oldEdu = disabilityMapper.selectById(disability.getId());
        if (oldEdu != null){
            disabilityService.removeById(oldEdu.getId());
        }
    }


    @PostMapping("/admin/list")
    public IPage<Disability> getAdminList(@RequestBody BusinessFilter filter)  {
        return disabilityService.getAdminList(filter.getPage(),filter.getLimit(),filter.getStatus());
    }

    @PostMapping("/admin/edit")
    public void editAdminData(@RequestBody Disability data)  {
        Disability oldData = disabilityMapper.selectById(data.getId());
        oldData.setStatus(data.getStatus());
        oldData.setReply(data.getReply());
        oldData.setUpdateTime(LocalDateTime.now());
        disabilityService.updateById(oldData);
    }
}

