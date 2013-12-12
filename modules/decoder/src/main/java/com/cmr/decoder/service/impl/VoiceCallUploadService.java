package com.cmr.decoder.service.impl;

import com.cmr.decoder.service.UploadService;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author rajith
 */
public class VoiceCallUploadService implements UploadService {

    private String[] files;

    private final Executor pool;

    public VoiceCallUploadService(int poolSize, String[] files) {
        this.files = files;
        pool = Executors.newFixedThreadPool(poolSize);
    }

    @Override
    public void upload() {

    }
}
