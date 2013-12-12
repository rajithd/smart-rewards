package com.cmr.decoder.scheduler.impl;

import com.cmr.decoder.scheduler.JobScheduler;
import com.cmr.decoder.service.UploadServiceStrategy;
import com.cmr.decoder.service.impl.VoiceCallUploadService;
import com.cmr.decoder.util.FileHandler;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author rajith
 */
public class VoiceCallEventScheduler implements JobScheduler {

    @Autowired
    private UploadServiceStrategy uploadServiceStrategy;

    private int poolSize;
    private String sourceDirectoryPath;
    private String fileNamePattern;

    @Override
    public void execute() {
        uploadServiceStrategy.startUpload(new VoiceCallUploadService(poolSize, getFiles()));
    }

    private String[] getFiles() {
        return FileHandler.getMatchingFiles(sourceDirectoryPath, fileNamePattern);
    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public void setSourceDirectoryPath(String sourceDirectoryPath) {
        this.sourceDirectoryPath = sourceDirectoryPath;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }
}
