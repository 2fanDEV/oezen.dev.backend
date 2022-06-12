package dev.oezen.spring.backend.controller;

import dev.oezen.spring.backend.services.MinioService.MinioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping( "/api/v0/minio")
public class MinioController {

    @Autowired
    private final MinioServiceImpl minioServiceImpl;

    public MinioController(MinioServiceImpl minioServiceImpl) {
        this.minioServiceImpl = minioServiceImpl;
    }

    /**
     * retrieve the textfile from the minioserver
     * @return this.minioServiceImpl.getTextFromS3Server
     */
    @GetMapping("/textfile/{bucketName}/file/{fileName}")
    public String getTextFileContentMinio(@PathVariable("bucketName") String bucketName,
                                       @PathVariable("fileName") String fileName) {
        return this.minioServiceImpl.getTextFromS3Server(bucketName, fileName);
    }

  /*  @GetMapping("/picture/{bucketName}/file/{pictureName}")
    public MultipartFile getPictureFromMinioServer(@PathVariable("bucketName") String bucketName,
                                                   @PathVariable("pictureName") String pictureName)
    {

    } */
}
