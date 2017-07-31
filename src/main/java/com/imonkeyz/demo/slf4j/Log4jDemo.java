package com.imonkeyz.demo.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Jesse on 2017/6/16.
 */
public class Log4jDemo {
    private static final Logger logger = LoggerFactory.getLogger(Log4jDemo.class);
    public static void main(String[] args) {
        String name = "hzh";
        logger.debug("Hello World");
        logger.info("hello {}", name);
    }
}
