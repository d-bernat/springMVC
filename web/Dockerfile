#
# Build stage
#
FROM dbernat/springmvc-parent as build
RUN ls /app/src

RUN mvn -f /app/src/pom.xml package


#
# Package stage
#
FROM openjdk:11-jre-slim
WORKDIR /app/src
COPY --from=build /app/src/web/target/web-1.0-SNAPSHOT.jar .
CMD ["java", "-jar", "web-1.0-SNAPSHOT.jar"]