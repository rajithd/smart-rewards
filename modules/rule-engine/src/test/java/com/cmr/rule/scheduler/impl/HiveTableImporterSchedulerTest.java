package com.cmr.rule.scheduler.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : rajith
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-rule-context.xml"})
public class HiveTableImporterSchedulerTest {

    @Autowired
    private HiveTableImporterScheduler hiveTableImporterScheduler;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testExecute() throws Exception {
        hiveTableImporterScheduler.execute();
    }
}
