package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Disability;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.demo.entity.Disability;
import com.wechat.demo.mapper.DisabilityMapper;
import org.springframework.stereotype.Service;

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
public class DisabilityService extends ServiceImpl<DisabilityMapper, Disability> {

    public IPage<Disability> getAdminList(Integer page, Integer limit, Integer status) {

        Disability.DisabilityBuilder builder = Disability.builder();
        if (Objects.nonNull(status) && status != -1) {
            builder.status(status);
        }
        Page<Disability> ipage = new Page<>(page, limit);
        IPage<Disability> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }
}
