FROM openjdk:18-alpine
COPY . .
RUN ./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=app
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]