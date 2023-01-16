/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.example.controller;

import com.tangv.core.constants.LogConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tangwei
 * @version MdcTraceController.java, v 0.1 2023/1/14 17:36 tangwei Exp $
 */
@RestController
public class MdcTraceController {

    Logger log = LoggerFactory.getLogger(MdcTraceController.class);

    @GetMapping("/mdc/trace")
    public Map<String, String> mdcTrace(@RequestParam String id, @RequestParam String name, @RequestParam String age, @RequestParam String msg) {
        Map<String, String> result = new HashMap<>(4);
        result.put("id", id);
        result.put("name", name);
        result.put("age", age);
        result.put("msg", msg);
        String traceId = MDC.get(LogConstants.TRACE_ID);
        log.info(traceId);
        log.debug(traceId);
        log.warn(traceId);
        log.error(traceId);
        log.trace(traceId);
        System.out.println(traceId);
        return result;
    }

}
