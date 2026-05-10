FROM eclipse-temurin:17-jdk-alpine

RUN apk update && apk add --no-cache rsync openssh

WORKDIR /test

ARG JAR_FILE

COPY ${JAR_FILE} ${JAR_FILE}

EXPOSE 8083

CMD ["sh","-c","java -jar ${JAR_FILE}"]
