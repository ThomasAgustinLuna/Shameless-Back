FROM openjdk:17-jdk-alpine

RUN mkdir -p /home/app

COPY target/Hackacode-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app/app.jar"]
