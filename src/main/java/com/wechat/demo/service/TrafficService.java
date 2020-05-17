package com.wechat.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Traffic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.demo.mapper.TrafficMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@Service
public class TrafficService extends ServiceImpl<TrafficMapper, Traffic>   {

}
