package com.data.m5p.config;

import com.data.m5p.utils.GlobalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Resource
    GlobalInterceptor globalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(globalInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
    }
}
