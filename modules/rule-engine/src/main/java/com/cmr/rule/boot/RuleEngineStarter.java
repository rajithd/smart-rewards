package com.cmr.rule.boot;


import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RuleEngineStarter {

    private final static org.slf4j.Logger logger = LoggerFactory.getLogger(RuleEngineStarter.class);

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("rule-context.xml");
        logger.info("####################################################");
        logger.info("#####       Rule Engine Started Successfully   #####");
        logger.info("####################################################");

    }
}
