package com.cmr.api.dao.impl;

import com.cmr.api.dao.RuleRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author : rajith
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:test-api-context.xml"})
public class RuleRepositoryImplTest {

    @Autowired
    private RuleRepository ruleRepository;

    @Test
    @Ignore
    public void testFindCollectionKeysByName() throws Exception {
        ruleRepository.findCollectionKeysByName("sms");
    }
}
