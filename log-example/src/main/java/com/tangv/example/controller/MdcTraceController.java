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
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangwei
 * @version MdcTraceController.java, v 0.1 2023/1/14 17:36 tangwei Exp $
 */
@RestController
public class MdcTraceController {

    Logger log = LoggerFactory.getLogger(MdcTraceController.class);

    @GetMapping("/mdc/trace")
    public void mdcTrace() {
        log.info(MDC.get(LogConstants.TRACE_ID));
    }

}
