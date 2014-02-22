package com.cmr.api.dao;

import com.cmr.beans.mongo.ValueObject;
import org.springframework.data.mongodb.core.mapreduce.MapReduceResults;

import java.util.Set;

/**
 * @author : rajith
 */
public interface RuleRepository {

    /**
     * Find all collections
     * @return
     */
    public Set<String> findAllCollections();

    /**
     * Find by collection names
     * @param collectionName
     * @return
     */
    public MapReduceResults<ValueObject> findCollectionKeysByName(String collectionName);

}
