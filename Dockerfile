FROM eclipse-temurin:17-jdk-alpine

RUN apk add --no-cache rsync openssh-client


WORKDIR /test

ARG JAR_FILE

COPY ${JAR_FILE} test.jar

EXPOSE 8080

CMD ["java","-jar","test.jar"]
