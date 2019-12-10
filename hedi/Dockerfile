FROM java:8
EXPOSE 8089
ADD /target/futuro-0.0.1-SNAPSHOT.jar docker-futuro.jar
ENTRYPOINT ["java", "-jar", "docker-futuro.jar"]