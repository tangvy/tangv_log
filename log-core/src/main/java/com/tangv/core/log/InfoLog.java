/**
 * shipper.id Inc.
 * Copyright (c) 2018-2022 All Rights Reserved.
 */
package com.tangv.core.log;

import org.apache.logging.log4j.Level;

import java.io.Serializable;

/**
 * @author tangwei
 * @version InfoLog.java, v 0.1 2023/1/18 14:58 tangwei Exp $
 */
public class InfoLog extends AbstractLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public Level level() {
        return Level.INFO;
    }
}
