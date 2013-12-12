package com.cmr.decoder.boot;

import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author rajith
 */
public class DecoderStarter {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(DecoderStarter.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("decoder-context.xml");
        logger.info("################################################");
        logger.info("#####       Decoder Started Successfully   #####");
        logger.info("################################################");
    }
}
