package com.cmr.api.dao.impl;

import com.cmr.api.dao.EventRepository;
import com.cmr.beans.event.AbstractEvent;
import com.cmr.beans.event.EventTypeEnum;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author rajith
 */
@Repository
public class EventRepositoryImpl implements EventRepository {

    @Override
    public void save(AbstractEvent abstractEvent) {
        //save event to database

    }

    @Override
    public List<AbstractEvent> findEventsByEventType(EventTypeEnum eventTypeEnum) {
        return null;
    }
}
