FROM openjdk:17
COPY /target/blog-gateway-0.0.1-SNAPSHOT.jar blog-gateway-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=server", "-jar", "blog-gateway-0.0.1-SNAPSHOT.jar"]