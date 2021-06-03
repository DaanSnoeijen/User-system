FROM openjdk:11-jre-slim
RUN apt-get update
ARG JAR_FILE=target/*.jar
COPY ${target/*.jar} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 8080
