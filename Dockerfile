FROM openjdk:8-jdk-alpine
MAINTAINER siheca
COPY target/pagila-api-docker.jar  /app-docker.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app-docker.jar"]