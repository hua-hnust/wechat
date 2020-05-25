package com.wechat.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wechat.demo.entity.Notice;
import com.wechat.demo.mapper.NoticeMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author wyulong
 * @since 2020-05-17
 */
@Service
public class NoticeService extends ServiceImpl<NoticeMapper, Notice> {

    public IPage<Notice> selectList(Integer page, Integer limit, String key) {

        Page<Notice> ipage = new Page<>(page, limit);
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("department", key);
        IPage<Notice> pageData = this.page(ipage, queryWrapper);
        return pageData;
    }

}
