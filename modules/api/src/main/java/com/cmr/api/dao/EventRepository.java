package com.cmr.api.dao;

import com.cmr.beans.event.AbstractEvent;
import com.cmr.beans.event.EventTypeEnum;

import java.util.List;

/**
 * @author rajith
 */
public interface EventRepository {

    /**
     * Save event
     * @param abstractEvent
     */
    public void save(AbstractEvent abstractEvent);

    /**
     * Find events by event type
     * @param eventTypeEnum
     * @param collectionName
     * @return
     */
    public List<AbstractEvent> findEventsByEventType(EventTypeEnum eventTypeEnum, String collectionName);

}
