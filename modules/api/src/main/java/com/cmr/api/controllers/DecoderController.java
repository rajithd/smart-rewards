package com.cmr.api.controllers;

import com.cmr.api.service.ReplicateService;
import com.cmr.beans.common.Success;
import com.cmr.beans.event.VoiceCallEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author rajith
 */
@Controller
public class DecoderController extends AbstractController {

    private final static Logger logger = LoggerFactory.getLogger(DecoderController.class);

    @Autowired
    private ReplicateService replicateService;

    @RequestMapping(method = RequestMethod.POST, value = "/replicate/voice/call", produces = "application/json")
    @ResponseBody
    public ResponseEntity replicateVoiceCallEvent(@RequestBody VoiceCallEvent voiceCallEvent){
        logger.info("Processing voice call event request");
        replicateService.replicateVoiceCallEvents(voiceCallEvent);
        logger.info("Successfully Processed voice call event request");
        return new ResponseEntity<Success>(Success.SUCCESS_CODE, HttpStatus.OK);
    }

}
