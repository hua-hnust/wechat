package com.wechat.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wechat.demo.constants.BusinessStatus;
import com.wechat.demo.dto.req.BusinessFilter;
import com.wechat.demo.entity.Traffic;
import com.wechat.demo.entity.User;
import com.wechat.demo.mapper.TrafficMapper;
import com.wechat.demo.service.TrafficService;
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
@RequestMapping("/traffic")
public class TrafficController {

    @Autowired
    private UserService userService;

    @Resource
    private TrafficMapper trafficMapper;

    @Autowired
    private TrafficService trafficService;

    @PostMapping("/addTraffic")
    @ResponseBody
    public void addTraffic(@RequestBody Traffic traffic) {
        Traffic oldEdu = new Traffic();
        User user = userService.currentUser();
        oldEdu.setId(null);
        oldEdu.setUserId(user.getId());
        oldEdu.setCarNumber(traffic.getCarNumber());
        oldEdu.setTitle(traffic.getTitle());
        oldEdu.setContent(traffic.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setCreateTime(LocalDateTime.now());
        oldEdu.setUpdateTime(LocalDateTime.now());
        trafficService.save(oldEdu);
    }

    @PostMapping("/listTraffic")
    @ResponseBody
    public List<Traffic> listTraffic() {
        User user = userService.currentUser();
        Traffic build = Traffic.builder().userId(user.getId()).build();
        return trafficMapper.selectList(new QueryWrapper<>(build));
    }

    @GetMapping("/getTraffic")
    @ResponseBody
    public Traffic getTraffic(@RequestParam("id") String id)  {
        return trafficMapper.selectById(id);
    }

    @PostMapping("/editTraffic")
    @ResponseBody
    public void editTraffic(@RequestBody Traffic traffic)  {
        Traffic oldEdu = trafficMapper.selectById(traffic.getId());
        oldEdu.setCarNumber(traffic.getCarNumber());
        oldEdu.setTitle(traffic.getTitle());
        oldEdu.setContent(traffic.getContent());
        oldEdu.setStatus(BusinessStatus.WAIT.getCode());
        oldEdu.setUpdateTime(LocalDateTime.now());
        trafficService.updateById(oldEdu);
    }

    @PostMapping("/deleteTraffic")
    @ResponseBody
    public void deleteTraffic(@RequestBody Traffic traffic)  {
        Traffic oldEdu = trafficMapper.selectById(traffic.getId());
        if (oldEdu != null){
            trafficService.removeById(oldEdu.getId());
        }
    }


    @PostMapping("/admin/list")
    public IPage<Traffic> getAdminList(@RequestBody BusinessFilter filter)  {
        return trafficService.getAdminListTraffic(filter.getPage(),filter.getLimit(),filter.getStatus());
    }

    @PostMapping("/admin/edit")
    public void editAdminData(@RequestBody Traffic traffic)  {
        Traffic oldData = trafficMapper.selectById(traffic.getId());
        oldData.setStatus(traffic.getStatus());
        oldData.setReply(traffic.getReply());
        oldData.setUpdateTime(LocalDateTime.now());
        trafficService.updateById(oldData);
    }
}

