FROM gradle:7-jdk17 AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle buildFatJar -no-daemon

FROM openjdk:17
EXPOSE 8080
RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/*.jar /app/tastytales-backend.jar
COPY src/main/resources/TastyTalesDatabase.db /app/TastyTalesDatabase.db
ENV DATABASE_PATH=/app/TastyTalesDatabase.db
ENTRYPOINT ["java","-jar","/app/tastytales-backend.jar"]