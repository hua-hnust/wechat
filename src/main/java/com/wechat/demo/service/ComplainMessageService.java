package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.ComplainMessage;
import com.wechat.demo.entity.ComplainMessage;
import com.wechat.demo.mapper.ComplainMessageMapper;
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
public class ComplainMessageService extends ServiceImpl<ComplainMessageMapper, ComplainMessage> {
    public IPage<ComplainMessage> getAdminList(Integer page, Integer limit, Integer status) {

        ComplainMessage.ComplainMessageBuilder builder = ComplainMessage.builder();
        if (Objects.nonNull(status) && status != -1) {
            builder.status(status);
        }
        Page<ComplainMessage> ipage = new Page<>(page, limit);
        IPage<ComplainMessage> pageData = this.page(ipage, new QueryWrapper<>(builder.build()));
        return pageData;
    }
}
