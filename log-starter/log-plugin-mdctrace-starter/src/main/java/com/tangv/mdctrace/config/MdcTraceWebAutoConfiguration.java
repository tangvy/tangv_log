/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.mdctrace.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author tangwei
 * @version MdcTraceWebAutoConfiguration.java, v 0.1 2023/1/14 17:20 tangwei Exp $
 */
@ConditionalOnClass(DispatcherServlet.class)
@AutoConfigureBefore(WebmvcConfiguration.class)
@Import(WebmvcConfiguration.class)
public class MdcTraceWebAutoConfiguration {
}
