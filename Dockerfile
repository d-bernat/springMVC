FROM maven:3.6-openjdk-11

WORKDIR /app/src

COPY pom.xml .

COPY core/src core/src
COPY core/pom.xml core

COPY console/src console/src
COPY console/pom.xml  console
RUN mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies
RUN mvn clean