#
#Build stage
#
FROM dbernat/springmvc-parent as build
RUN ls /app/src
RUN mvn -f /app/src/pom.xml clean package


#
# Package stage
#
FROM openjdk:11-jre-slim
WORKDIR /app/src
COPY --from=build /app/src/core/target/core-1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "core-1.0-SNAPSHOT.jar"]