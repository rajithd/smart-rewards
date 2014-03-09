package com.cmr.util;

/**
 * @author rajith
 */
public interface Constants {
    /**
     * Decoder related constants
     */
    public final static String ESB_SERVICE_VOICE_CALL = "esb/replicate/voice/call";
    public final static String ESB_SERVICE_SMS = "esb/replicate/sms";
    public final static String ESB_SERVICE_ACTIVATION = "esb/replicate/activation";
    public final static String ESB_SERVICE_REGISTRATION = "replicateregistration";

    /**
     * Rule Engine related constants
     */
    public final static String ESB_RULE_FIND_ALL_COLLECTION_NAMES = "esb/get/collection/names";
    public final static String ESB_RULE_FIND_COLUMNS_BY_NAME = "getCollectionColumnsByName";

    public final static String COLLECTION_SYSTEM_INDEX = "system.indexes";
    public final static String COLLECTION_CLASS_COL_NAME = "_class";
    public final static String COLLECTION_CLASS_ID_NAME = "_id";
    public final static String COLLECTION_CLASS_ID_NEW_NAME = "id";

    public final static String COLLECTION_SMS_NAME = "sms";
    public final static String COLLECTION_VOICE_CALL_NAME = "voiceCall";
    public final static String COLLECTION_ACTIVATION_NAME = "activation";
    public final static String COLLECTION_REGISTRATON_NAME = "registration";


    /**
     * Auth related constants
     */
    public final static String USER_TYPE_ADMIN = "ADMIN";
    public final static String USER_TYPE_MANAGER = "MANAGER";

    /**
     * Campaign management related constants
     */

    public final static String ESB_SERVICE_CREATE_USER = "esb/user/save";
    public final static String ESB_SERVICE_CREATE_CAMPAIGN = "esb/campaign/save";
    public final static String ESB_SERVICE_GET_CAMPAIGNS = "esb/campaign/find/all";

}
