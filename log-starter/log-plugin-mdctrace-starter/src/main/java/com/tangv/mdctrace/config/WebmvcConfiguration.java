/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.mdctrace.config;

import com.tangv.mdctrace.interceptor.MdcTraceInterceptor;
import com.tangv.mdctrace.interceptor.RequestLogInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServlet;

/**
 * @author tangwei
 * @version WebmvcConfig.java, v 0.1 2023/1/14 17:14 tangwei Exp $
 */
@Configuration
@ConditionalOnClass({DispatcherServlet.class, HttpServlet.class})
public class WebmvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(mdcTraceInterceptor());
        registry.addInterceptor(requestLogInterceptor());
    }

    @Bean
    @ConditionalOnMissingBean
    public MdcTraceInterceptor mdcTraceInterceptor() {
        return new MdcTraceInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean
    public RequestLogInterceptor requestLogInterceptor() {
        return new RequestLogInterceptor();
    }
}
