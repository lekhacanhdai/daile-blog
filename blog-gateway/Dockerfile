FROM openjdk:17
COPY /target/blog-gateway-1.0.0.jar blog-gateway-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-Dspring.profiles.active=server", "-jar", "blog-gateway-1.0.0.jar"]