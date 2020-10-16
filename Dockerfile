FROM maven:3.6-openjdk-11

WORKDIR /app/src

COPY pom.xml .

COPY core/src core/src
COPY core/pom.xml core

COPY web/src web/src
COPY web/pom.xml  web
RUN mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies
RUN mvn clean