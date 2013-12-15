package com.cmr.decoder.scheduler.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author rajith
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-decoder-context.xml"})
public class SMSEventSchedulerTest {

    @Autowired
    private SMSEventScheduler smsEventScheduler;

    @Test
    public void testExecute() throws Exception {
        smsEventScheduler.execute();
    }
}
