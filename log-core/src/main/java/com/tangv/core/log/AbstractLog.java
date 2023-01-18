/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.core.log;

import org.apache.logging.log4j.Level;
import org.slf4j.MDC;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author tangwei
 * @version AbstractLog.java, v 0.1 2023/1/18 14:45 tangwei Exp $
 */
public abstract class AbstractLog implements Serializable {

    public abstract Level level();

}
