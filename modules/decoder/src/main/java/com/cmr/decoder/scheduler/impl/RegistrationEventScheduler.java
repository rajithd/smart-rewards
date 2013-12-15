package com.cmr.decoder.scheduler.impl;

import com.cmr.decoder.config.RestConfig;
import com.cmr.decoder.scheduler.JobScheduler;
import com.cmr.decoder.service.UploadServiceStrategy;
import com.cmr.decoder.service.impl.RegistrationUploadService;
import com.cmr.decoder.util.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

/**
 * @author rajith
 */
public class RegistrationEventScheduler implements JobScheduler {

    private final static Logger logger = LoggerFactory.getLogger(RegistrationEventScheduler.class);

    @Autowired
    private UploadServiceStrategy uploadServiceStrategy;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private RestConfig restConfig;

    private int poolSize;
    private String sourceDirectoryPath;
    private String archiveDirectoryPath;
    private String fileNamePattern;
    private String columnSeparator;
    private String rawBreaker;

    @Override
    public void execute() {
        logger.info("Registration event scheduler starting to execute");
        uploadServiceStrategy.startUpload(new RegistrationUploadService(poolSize, getFiles(),
                sourceDirectoryPath, archiveDirectoryPath, columnSeparator, rawBreaker, restTemplate ,restConfig));

    }

    public void setPoolSize(int poolSize) {
        this.poolSize = poolSize;
    }

    public void setSourceDirectoryPath(String sourceDirectoryPath) {
        this.sourceDirectoryPath = sourceDirectoryPath;
    }

    public void setArchiveDirectoryPath(String archiveDirectoryPath) {
        this.archiveDirectoryPath = archiveDirectoryPath;
    }

    public void setFileNamePattern(String fileNamePattern) {
        this.fileNamePattern = fileNamePattern;
    }

    public void setColumnSeparator(String columnSeparator) {
        this.columnSeparator = columnSeparator;
    }

    public void setRawBreaker(String rawBreaker) {
        this.rawBreaker = rawBreaker;
    }

    private String[] getFiles() {
        return FileHandler.getMatchingFiles(sourceDirectoryPath, fileNamePattern);
    }
}
