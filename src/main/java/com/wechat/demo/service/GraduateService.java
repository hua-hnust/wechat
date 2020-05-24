package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Graduate;
import com.wechat.demo.entity.Graduate;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.demo.mapper.GraduateMapper;
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
public class GraduateService extends ServiceImpl<GraduateMapper, Graduate>   {

    public IPage<Graduate> getAdminList(Integer page, Integer limit, Integer status) {

        Graduate.GraduateBuilder builder = Graduate.builder();
        if (Objects.nonNull(status) && status != -1) {
            builder.status(status);
        }
        Page<Graduate> ipage = new Page<>(page, limit);
        IPage<Graduate> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }
}
