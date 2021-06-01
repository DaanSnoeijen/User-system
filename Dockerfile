FROM openjdk:11-jre-slim
RUN apt-get update
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} *.jar
ENTRYPOINT ["java","-jar","/*.jar"]
