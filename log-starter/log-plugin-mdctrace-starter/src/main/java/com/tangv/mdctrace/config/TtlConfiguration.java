/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.mdctrace.config;

import ch.qos.logback.classic.util.LogbackMDCAdapter;
import com.alibaba.ttl.TransmittableThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServlet;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author tangwei
 * @version TtlConfiguration.java, v 0.1 2023/1/18 16:07 tangwei Exp $
 */
@Configuration
@ConditionalOnClass({DispatcherServlet.class, HttpServlet.class})
public class TtlConfiguration {
    static final Logger log = LoggerFactory.getLogger(TtlConfiguration.class);

    static {
        try {
            String copyOnThreadLocal = "copyOnThreadLocal";
            String mdcAdapter = "mdcAdapter";
            ThreadLocal<Map<String, String>> threadLocal = new TransmittableThreadLocal<>();
            LogbackMDCAdapter logbackMDCAdapter = new LogbackMDCAdapter();
            Field copyOnThreadLocalField = LogbackMDCAdapter.class.getDeclaredField(copyOnThreadLocal);
            copyOnThreadLocalField.setAccessible(true);
            copyOnThreadLocalField.set(logbackMDCAdapter, threadLocal);

            Field mdcAdapterField = MDC.class.getDeclaredField(mdcAdapter);
            mdcAdapterField.setAccessible(true);
            mdcAdapterField.set(Field.class, logbackMDCAdapter);
        } catch (Exception e) {
            log.error("set custom MDC adapter failed", e);
        }
    }
}
