package com.wechat.demo.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author xhua
 * @Date 2020/5/8 16:15
 **/
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private UploadConfiguration uploadConfiguration;

    /**
     *  资源路径映射
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //外部资源 内部依赖 JS、CSS等
        registry.addResourceHandler("/static/**").addResourceLocations("file:///" +uploadConfiguration.getFilePath())
                .addResourceLocations("classpath:/static/");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //TODO 可插拔拦截器
    }

}
