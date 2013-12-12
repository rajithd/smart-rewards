package com.cmr.api.dao;

import com.cmr.beans.event.AbstractEvent;
import com.cmr.beans.event.EventTypeEnum;

import java.util.List;

/**
 * @author rajith
 */
public interface EventRepository {

    public void save(AbstractEvent abstractEvent);

    public List<AbstractEvent> findEventsByEventType(EventTypeEnum eventTypeEnum);

}
