FROM openjdk:17
COPY /target/blog-file-1.0.0.jar blog-file-1.0.0.jar
EXPOSE 8080 6565
ENTRYPOINT ["java","-Dspring.profiles.active=server", "-jar", "blog-file-1.0.0.jar"]