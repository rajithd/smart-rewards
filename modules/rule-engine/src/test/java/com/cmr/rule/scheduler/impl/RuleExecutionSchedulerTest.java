package com.cmr.rule.scheduler.impl;

import com.cmr.rule.service.MailSender;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * @author rajith
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-rule-context.xml"})
public class RuleExecutionSchedulerTest {

    @Autowired
    private RuleExecutionScheduler ruleExecutionScheduler;
    @Autowired
    private MailSender mailSender;

    @Ignore
    @Test
    public void testExecute() throws Exception {
        ruleExecutionScheduler.execute();

    }
}
