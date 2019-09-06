FROM gradle:5.6.1-jdk12 as build

WORKDIR /app

COPY *.* ./
COPY src ./src
#COPY src src

RUN pwd
RUN ls -la
RUN gradle build && \
    jlink --add-modules ds.test.sandbox \
         --module-path ${JAVA_HOME}/jmods:build/libs/sandbox-0.0.1-SNAPSHOT.jar \
         --output build/libs/jlink-image \
         --launcher ds.test.sandbox=ds.test.sandbox/ds.test.sandbox.SandboxApplication

FROM openjdk:12-alpine

COPY --from=build /app/build/libs/sandbox-0.0.1-SNAPSHOT.jar \
                  /sandbox-0.0.1-SNAPSHOT.jar

##ENTRYPOINT ["java", "-jar"]
CMD ["/sandbox-0.0.1-SNAPSHOT.jar"]
#CMD date