package com.udemy.service.impl;

import com.udemy.service.Checkpoint1Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

@Service("checkpoint1Service")
public class Checkpoint1ServiceImpl implements Checkpoint1Service{

    private static final Log LOGGER = LogFactory.getLog(Checkpoint1ServiceImpl.class);

    @Override
    public void showMessage() {
        LOGGER.info("Checkpoint1ServiceImpl");
    }

}
