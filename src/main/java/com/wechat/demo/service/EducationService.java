package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Education;
import com.wechat.demo.mapper.EducationMapper;
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
public class EducationService extends ServiceImpl<EducationMapper, Education>   {


    public IPage<Education> getAdminListEducations(Integer page, Integer pageSize, Integer status) {
        Education.EducationBuilder builder = Education.builder();
        if (Objects.nonNull(status) && status != -1){
            builder.status(status);
        }
        Page<Education> ipage = new Page<>(page,pageSize);

        IPage<Education> educationIPage = this.page(ipage, new QueryWrapper<>(builder.build()));

        return educationIPage;
    }
}
