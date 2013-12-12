package com.cmr.decoder.service;

import org.springframework.stereotype.Service;

/**
 * @author rajith
 */
@Service
public class UploadServiceStrategy {

    public void startUpload(UploadService uploadService){
        uploadService.upload();
    }
}
