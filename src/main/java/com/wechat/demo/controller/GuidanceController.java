package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.dto.req.BusinessFilter;
import com.wechat.demo.entity.Guidance;
import com.wechat.demo.mapper.GuidanceMapper;
import com.wechat.demo.service.GuidanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@RestController
@RequestMapping("/guidance")
public class GuidanceController {

    @Resource
    private GuidanceMapper guidanceMapper;

    @Resource
    private GuidanceService guidanceService;

    @PostMapping("/addGuidance")
    @ResponseBody
    public void addGuidance(@RequestBody Guidance guidance) {
        Guidance newGuidance = new Guidance();
        newGuidance.setId(null);
        newGuidance.setType(guidance.getType());
        newGuidance.setTitle(guidance.getTitle());
        newGuidance.setContent(guidance.getContent());
        newGuidance.setStatus(BusinessStatus.WAIT.getCode());
        newGuidance.setCreateTime(LocalDateTime.now());
        newGuidance.setUpdateTime(LocalDateTime.now());
        guidanceService.save(newGuidance);
    }

    @PostMapping("/listGuidance")
    @ResponseBody
    public IPage<Guidance> listGuidance(@RequestBody BusinessFilter filter)  {
        return guidanceService.selectList(filter.getPage(),filter.getLimit(),filter.getType());
    }

    @GetMapping("/getGuidance")
    @ResponseBody
    public Guidance getGuidance(@RequestParam("id") String id)  {
        return guidanceMapper.selectById(id);
    }

    @PostMapping("/editGuidance")
    @ResponseBody
    public void editGuidance(@RequestBody Guidance guidance)  {
        Guidance oldEdu = guidanceMapper.selectById(guidance.getId());
        oldEdu.setTitle(guidance.getTitle());
        oldEdu.setContent(guidance.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        guidanceService.updateById(oldEdu);
    }

    @PostMapping("/deleteGuidance")
    @ResponseBody
    public void deleteGuidance(@RequestBody Guidance guidance)  {
        Guidance oldEdu = guidanceMapper.selectById(guidance.getId());
        if (oldEdu != null){
            guidanceService.removeById(oldEdu.getId());
        }
    }
}

