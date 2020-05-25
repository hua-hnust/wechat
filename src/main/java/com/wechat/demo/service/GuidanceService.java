package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Guidance;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.demo.mapper.GuidanceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@Service
public class GuidanceService extends ServiceImpl<GuidanceMapper, Guidance>   {

    public IPage<Guidance> selectList(Integer page, Integer limit, Integer type) {
        Guidance.GuidanceBuilder builder = Guidance.builder();
        if (Objects.nonNull(type) && type != -1) {
            builder.type(type);
        }
        Page<Guidance> ipage = new Page<>(page, limit);
        IPage<Guidance> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }
}
