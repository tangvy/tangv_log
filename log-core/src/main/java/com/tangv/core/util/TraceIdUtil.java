/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.core.util;

import com.tangv.core.constants.LogConstants;
import com.tangv.core.util.sign.SignUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author tangwei
 * @version TraceIdUtil.java, v 0.1 2023/1/14 16:51 tangwei Exp $
 */
public class TraceIdUtil {

    public static String traceRequest(HttpServletRequest request) {
        String shortTraceId = LogConstants.EMPTY;
        /*if (request == null) {
            return shortTraceId;
        }

        shortTraceId = request.getHeader(SHORT_TRACE_ID);
        if (!(shortTraceId == null || shortTraceId.isEmpty())) {
            return shortTraceId;
        }*/


        String originalTraceId = request.getHeader("user-agent");

        //这里进行traceID和spanId的结合
        String ip = IpTool.getRealIp(request);
        shortTraceId = SignUtil.sign((originalTraceId == null ? LogConstants.EMPTY : originalTraceId)+System.currentTimeMillis(), SignUtil.BIT._62) + IpCryptUtil.encode(ip);

        return shortTraceId;
    }

}
