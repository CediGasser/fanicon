FROM gcr.io/distroless/java-debian10:11
ARG JAR_FILE=build/libs/*.jar
RUN echo "Jar file found: $JAR_FILE"
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
