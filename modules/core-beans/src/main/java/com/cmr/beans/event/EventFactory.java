package com.cmr.beans.event;

/**
 * @author rajith
 */
public final class EventFactory {

    private EventFactory() {
    }

    public static AbstractEvent buildEventWithValues(EventTypeEnum event, String[] columnValues){
        AbstractEvent abstractEvent = buildEvent(event);
        abstractEvent.setId(columnValues[0]);
        abstractEvent.setCaller(columnValues[1]);
        abstractEvent.setCallee(columnValues[2]);

        //TODO fill values
        return abstractEvent;
    }

    public static AbstractEvent buildEvent(EventTypeEnum event) {
        switch (event) {
            case VOICE_CALL_EVENT:
                return new VoiceCallEvent();
            case VOICE_MAIL_EVENT:
                return new VoiceMailEvent();
            case ACTIVATION_EVENT:
                return new ActivationEvent();
            case SMS_EVENT:
                return new SMSEvent();
            case ECOMMERCE_EVENT:
                return new EcommerceEvent();
            case DATA_EVENT:
                return new DataEvent();
            case REGISTRATION_EVENT:
                return new RegistrationEvent();
        }
        return null;
    }
}
