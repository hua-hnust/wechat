package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.ConsultMessage;
import com.wechat.demo.mapper.ConsultMessageMapper;
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
public class ConsultMessageService extends ServiceImpl<ConsultMessageMapper, ConsultMessage> {

    public IPage<ConsultMessage> getAdminList(Integer page, Integer limit, Integer status) {

        ConsultMessage.ConsultMessageBuilder builder = ConsultMessage.builder();
        if (Objects.nonNull(status) && status != -1) {
            builder.status(status);
        }
        Page<ConsultMessage> ipage = new Page<>(page, limit);
        IPage<ConsultMessage> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }
}
