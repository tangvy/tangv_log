/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.mdctrace.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.Map;

/**
 * @author tangwei
 * @version RequestLogInterceptor.java, v 0.1 2023/1/16 14:07 tangwei Exp $
 */
public class RequestLogInterceptor implements HandlerInterceptor {

    Logger log = LoggerFactory.getLogger(RequestLogInterceptor.class);

    StopWatch stopWatch = new StopWatch("trace");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        stopWatch.start();
        log.info("=================================================");
        log.info("URL          : {}", request.getRequestURL().toString());
        log.info("HTTP Method  : {}", request.getMethod());
        log.info("IP           : {}", request.getRemoteAddr());
        log.info("Request Args : {}", getParamString(request.getParameterMap()));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        stopWatch.stop();
        log.info("URL          : {}", request.getRequestURL().toString());
        log.info("Request Args : {}", getParamString(request.getParameterMap()));
        log.info("Total Cost   : {} ms", stopWatch.getTotalTimeMillis());
        log.info("=================================================");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    /**
     * 获取参数的字符串形式
     *
     * @param map
     * @return
     */
    private String getParamString(Map<String, String[]> map) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String[]> e : map.entrySet()) {
            sb.append(e.getKey()).append("=");
            String[] value = e.getValue();
            if (value != null && value.length == 1) {
                sb.append(value[0]).append("&");
            } else {
                sb.append(Arrays.toString(value)).append("&");
            }
        }
        if (sb.length() >= 1) {
            if (sb.substring(sb.length() - 1, sb.length()).equals("&")) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }
}
