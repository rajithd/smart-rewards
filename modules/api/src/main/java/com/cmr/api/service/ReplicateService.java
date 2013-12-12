package com.cmr.api.service;

import com.cmr.beans.event.VoiceCallEvent;

/**
 * @author rajith
 */
public interface ReplicateService {

    public void replicateVoiceCallEvents(VoiceCallEvent voiceCallEvent);

}
