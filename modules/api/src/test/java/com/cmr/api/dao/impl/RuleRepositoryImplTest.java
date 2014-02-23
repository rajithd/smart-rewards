package com.cmr.api.dao.impl;

import com.cmr.api.dao.EventRepository;
import com.cmr.api.dao.RuleRepository;
import com.cmr.beans.event.AbstractEvent;
import com.cmr.beans.event.EventTypeEnum;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author : rajith
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-api-context.xml"})
public class RuleRepositoryImplTest {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private EventRepository eventRepository;

    @Test
    @Ignore
    public void testFindCollectionKeysByName() throws Exception {
        ruleRepository.findCollectionKeysByName("sms");
    }

    @Test
    @Ignore
    public void testFindEvents() throws Exception {
        List<AbstractEvent> sms = eventRepository.findEventsByEventType(EventTypeEnum.SMS_EVENT, "sms");
        System.out.println(sms.size());


    }
}
