FROM openjdk:17
COPY /target/blog-auth-0.0.1-SNAPSHOT.jar blog-auth-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Dspring.profiles.active=server", "-jar", "blog-auth-0.0.1-SNAPSHOT.jar"]