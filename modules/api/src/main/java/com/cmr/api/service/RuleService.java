package com.cmr.api.service;

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

}
