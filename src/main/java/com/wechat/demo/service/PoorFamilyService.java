package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.PoorFamily;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wechat.demo.entity.PoorFamily;
import com.wechat.demo.mapper.PoorFamilyMapper;
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
public class PoorFamilyService extends ServiceImpl<PoorFamilyMapper, PoorFamily>   {

    public IPage<PoorFamily> getAdminList(Integer page, Integer limit, Integer status) {
        PoorFamily.PoorFamilyBuilder builder = PoorFamily.builder();
        if (Objects.nonNull(status) && status != -1) {
            builder.status(status);
        }
        Page<PoorFamily> ipage = new Page<>(page, limit);
        IPage<PoorFamily> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }
}
