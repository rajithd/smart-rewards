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
public class VoiceCallEventSchedulerTest {

    @Autowired
    private VoiceCallEventScheduler voiceCallEventScheduler;

    @Test
    public void testExecute() throws Exception {
        voiceCallEventScheduler.execute();
    }
}
