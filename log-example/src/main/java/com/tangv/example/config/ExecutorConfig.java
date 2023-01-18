/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author tangwei
 * @version ExecutorConfig.java, v 0.1 2023/1/18 15:24 tangwei Exp $
 */
@Configuration
public class ExecutorConfig {
    AtomicInteger count = new AtomicInteger();

    @Bean(name = "tangExecutor")
    public Executor tangExecutor() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        return new Thread(r, "tangv-aync-" + count.incrementAndGet());
                    }
                });
        return executor;
    }

}
