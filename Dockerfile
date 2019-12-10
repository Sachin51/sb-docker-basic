FROM openjdk:latest

From tomcat:9.0-jdk11-openjdk-slim

RUN rm -rf /usr/local/tomcat/webapps/*

COPY ./target/sb-docker-basic-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/successapp.war

CMD ["catalina.sh","run"]