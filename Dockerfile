LABEL authors="tiemonl"
FROM gradle:7.6.1-jdk17-alpine
USER bot
WORKDIR /builder
ADD . /builder
RUN gradle build --stacktrace

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /builder/build/libs/toebot.jar .

ENTRYPOINT ["java", "-jar", "toebot.jar"]