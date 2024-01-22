FROM openjdk:17-alpine
#RUN apk add --no-cache openjdk17
COPY build/libs/*.jar /app/
WORKDIR /app/
RUN mv /app/*.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
