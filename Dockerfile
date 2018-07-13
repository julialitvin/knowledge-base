FROM java:8 as builder

WORKDIR /tmp
COPY . /tmp

RUN chmod +x gradlew
RUN ./gradlew clean build

FROM openjdk:8-jre-alpine

COPY --from=builder /tmp/build/libs/knowledge-base-0.0.1-SNAPSHOT.jar /tmp

EXPOSE 8080

CMD java -jar /tmp/knowledge-base-0.0.1-SNAPSHOT.jar