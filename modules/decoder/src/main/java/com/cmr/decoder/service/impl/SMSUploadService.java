package com.cmr.decoder.service.impl;

import com.cmr.decoder.config.RestConfig;
import com.cmr.decoder.service.UploadService;
import com.cmr.decoder.service.impl.thread.SMSProcessorThread;
import com.cmr.decoder.service.impl.thread.VoiceCallProcessorThread;
import com.cmr.decoder.util.FileHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author rajith
 */
public class SMSUploadService implements UploadService {

    private static final Logger logger = LoggerFactory.getLogger(SMSUploadService.class);
    private static final CharsetDecoder decoder = Charset.forName("ISO-8859-1").newDecoder();

    private String[] files;

    private final Executor pool;
    private String sourceDirectoryPath;
    private String archiveDirectoryPath;
    private String columnSeparator;
    private String rawBreaker;
    private RestTemplate restTemplate;
    private RestConfig restConfig;

    public SMSUploadService(int poolSize, String[] files, String sourceDirectoryPath, String archiveDirectoryPath,
                                  String columnSeparator, String rawBreaker, RestTemplate restTemplate, RestConfig restConfig) {
        this.files = files;
        pool = Executors.newFixedThreadPool(poolSize);
        this.sourceDirectoryPath = sourceDirectoryPath;
        this.rawBreaker = rawBreaker;
        this.columnSeparator = columnSeparator;
        this.archiveDirectoryPath = archiveDirectoryPath;
        this.restTemplate = restTemplate;
        this.restConfig = restConfig;
    }

    @Override
    public void upload() {
        if(files.length == 0){
            logger.info("Not found any new files. Exiting");
            return;
        }
        for (String file : files) {
            try {
                logger.info("Started to process [{}] file", file);
                readAndSendInfo(file);
                logger.info("Successfully send records to API in the file [{}]", file);
                archiveTheFile(file);
            } catch (Exception e) {
                logger.error("Unexpected error while reading the file [" + file + "]", e);
            }
        }

    }


    private void readAndSendInfo(String file) throws IOException {
        FileChannel channel = null;
        FileInputStream inFile = null;
        String fullPath = sourceDirectoryPath + file;
        try {
            logger.info("Reading the file [ {} ] started", file);
            StringBuilder builder = new StringBuilder();
            inFile = new FileInputStream(fullPath);
            channel = inFile.getChannel();
            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
            CharBuffer charBuffer = decoder.decode(buffer);
            char character;
            while (charBuffer.hasRemaining()) {
                character = charBuffer.get();
                builder.append(character);
                if (character == rawBreaker.charAt(0)) {
                    pool.execute(new SMSProcessorThread(builder.toString(),
                            columnSeparator,restTemplate, restConfig));
                    builder = new StringBuilder();
                }
            }
            logger.info("Reading the file [{}] completed", file);
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
                if (inFile != null) {
                    inFile.close();
                }
            } catch (Exception e) {
                logger.error("Error occur while closing the channel");
            }
        }
    }

    private void archiveTheFile(String file) {
        logger.info("Archiving the file [{}]", file);
        FileHandler.moveDataFile(sourceDirectoryPath + file, archiveDirectoryPath);
    }
}
