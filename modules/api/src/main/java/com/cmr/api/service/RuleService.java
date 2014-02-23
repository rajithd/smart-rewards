package com.cmr.api.service;

import com.cmr.beans.event.AbstractEvent;

import java.util.List;
import java.util.Set;

/**
 * @author : rajith
 */
public interface RuleService {

    /**
     * Find all collection names
     * @return
     */
    public Set<String> getAllCollectionName();

    /**
     * Find collection keys
     * @param collectionName
     * @return
     */
    public Set<String> getCollectionColumnsByName(String collectionName);

    /**
     *
     * @param eventType
     * @return
     */
    public List<AbstractEvent> findEventsByEventType(String eventType);

}
