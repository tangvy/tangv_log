/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.example.config;

import com.alibaba.ttl.threadpool.TtlExecutors;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;

/**
 * @author tangwei
 * @version WssProcessor.java, v 0.1 2023/1/18 15:33 tangwei Exp $
 */
@Component
public class ExecutorDecorateProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof Executor) {
            Executor executor = (Executor) bean;
            if (!TtlExecutors.isTtlWrapper(executor)) {
                return TtlExecutors.getTtlExecutor(executor);
            }
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
