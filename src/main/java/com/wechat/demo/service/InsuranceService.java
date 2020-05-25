package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Insurance;
import com.wechat.demo.mapper.InsuranceMapper;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-05-26
 */
@Service
public class InsuranceService extends ServiceImpl<InsuranceMapper,  Insurance> {



    public IPage<Insurance> selectList(Integer page, Integer limit, Integer type,Integer status) {
        Insurance.InsuranceBuilder builder = Insurance.builder();
        if (Objects.nonNull(type) && type != -1) {
            builder.type(type);
        }
        if (Objects.nonNull(status) && status != -1) {
            builder.status(status);
        }
        Page<Insurance> ipage = new Page<>(page, limit);
        IPage<Insurance> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }

}
