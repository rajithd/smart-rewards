package com.cmr.rule.scheduler;

import java.sql.SQLException;

/**
 * @author : rajith
 */
public interface RuleJobScheduler {

    public void execute() throws InterruptedException, SQLException;
}
