FROM amazoncorretto:17.0.7-alpine
EXPOSE 8081
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java", "-jar", "/spring-boot-docker.jar"]