package com.cmr.util;

/**
 * @author rajith
 */
public interface Constants {
    /**
     * Decoder related constants
     */
    public final static String ESB_SERVICE_VOICE_CALL = "replicatevoicecall";
    public final static String ESB_SERVICE_SMS = "replicatesms";
    public final static String ESB_SERVICE_ACTIVATION = "replicateactivation";
    public final static String ESB_SERVICE_REGISTRATION = "replicateregistration";

    /**
     * Rule Engine related constants
     */
    public final static String ESB_RULE_FIND_ALL_COLLECTION_NAMES = "getAllCollections";
    public final static String ESB_RULE_FIND_COLUMNS_BY_NAME = "getCollectionColumnsByName";

    public final static String COLLECTION_SYSTEM_INDEX = "system.indexes";
    public final static String COLLECTION_CLASS_COL_NAME = "_class";
    public final static String COLLECTION_CLASS_ID_NAME = "_id";
    public final static String COLLECTION_CLASS_ID_NEW_NAME = "id";


    /**
     * Auth related constants
     */
    public final static String USER_TYPE_ADMIN = "ADMIN";
    public final static String USER_TYPE_MANAGER = "MANAGER";

    /**
     * Campaign management related constants
     */

    public final static String ESB_SERVICE_CREATE_USER = "createUser";

}
