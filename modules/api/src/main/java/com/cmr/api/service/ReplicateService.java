package com.cmr.api.service;

import com.cmr.beans.event.ActivationEvent;
import com.cmr.beans.event.RegistrationEvent;
import com.cmr.beans.event.SMSEvent;
import com.cmr.beans.event.VoiceCallEvent;

/**
 * @author rajith
 */
public interface ReplicateService {

    /**
     * Replicate voice call
     * @param voiceCallEvent
     */
    public void replicateVoiceCallEvents(VoiceCallEvent voiceCallEvent);

    /**
     * Replicate SMS
     * @param smsEvent
     */
    public void replicateSMSEvents(SMSEvent smsEvent);

    /**
     * Replicate activation event
     * @param activationEvent
     */
    public void replicateActivationEvent(ActivationEvent activationEvent);

    /**
     * Replicate registration event
     * @param registrationEvent
     */
    public void replicateRegistrationEvent(RegistrationEvent registrationEvent);

}
