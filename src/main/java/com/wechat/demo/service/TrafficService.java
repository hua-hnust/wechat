package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Traffic;
import com.wechat.demo.mapper.TrafficMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@Service
public class TrafficService extends ServiceImpl<TrafficMapper, Traffic> {

    public IPage<Traffic> getAdminListTraffic(Integer page, Integer limit, Integer status) {

        Traffic.TrafficBuilder builder = Traffic.builder();
        if (Objects.nonNull(status) && status != -1) {
            builder.status(status);
        }
        Page<Traffic> ipage = new Page<>(page, limit);
        IPage<Traffic> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }

}
