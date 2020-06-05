FROM openjdk:8-jre
RUN mkdir app
ARG JAR_FILE
ADD /target/${JAR_FILE} /app/nova-0.0.1-SNAPSHOT.jar
WORKDIR /app
ENTRYPOINT java -jar nova-0.0.1-SNAPSHOT.jar