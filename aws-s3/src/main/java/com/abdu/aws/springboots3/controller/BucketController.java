
package com.abdu.aws.springboots3.controller;

import com.abdu.aws.springboots3.service.BucketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/storage/")
public class BucketController {

    private BucketService bucketService;

    @Autowired
    BucketController(BucketService bucketService) {
        this.bucketService = bucketService;
    }

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return bucketService.uploadFile(file);
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestPart(value = "url") String fileUrl) {
        return bucketService.deleteFileFromS3Bucket(fileUrl);
    }


}
