package dev.oezen.spring.backend.services.MinioService;

public interface MinioServiceInterface {

    public String getTextFromS3Server(String bucketName, String fileName);

}
