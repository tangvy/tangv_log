/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.mdctrace.interceptor;

import cn.hutool.core.util.StrUtil;
import com.tangv.core.constants.LogConstants;
import com.tangv.core.util.TraceIdUtil;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author tangwei
 * @version MdcTraceInterceptor.java, v 0.1 2023/1/14 16:21 tangwei Exp $
 */
public class MdcTraceInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String traceId = request.getHeader(LogConstants.TRACE_ID);
        if (StrUtil.isEmpty(traceId)) {
            traceId = TraceIdUtil.traceRequest(request);
        }
        MDC.put(LogConstants.TRACE_ID, traceId);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        response.setHeader(LogConstants.TRACE_ID, MDC.get(LogConstants.TRACE_ID));
        MDC.remove(LogConstants.TRACE_ID);
    }
}
