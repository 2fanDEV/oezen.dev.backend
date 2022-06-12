package dev.oezen.spring.backend.services.MinioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import javax.transaction.Transactional;

@Service
@Transactional
public class MinioServiceImpl implements MinioServiceInterface{


    private final WebClient webClient;
    @Autowired
    public MinioServiceImpl(@Value("${spring.minio.url}") String BASE_URL) {
        System.out.println("\n\n BaseUrl: " + BASE_URL + "\n");
        this.webClient = WebClient.builder()
                .baseUrl(BASE_URL)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.TEXT_PLAIN))
                .build();
    }


    @Override
    public String getTextFromS3Server(String bucketName, String fileName) {
       return this.webClient.get().uri("/" + bucketName + "/" + fileName)
                .header(HttpHeaders.CONTENT_TYPE, String.valueOf(MediaType.TEXT_PLAIN))
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
