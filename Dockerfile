FROM maven:3.6-openjdk-11
WORKDIR /app/src
COPY pom.xml .
COPY core/src core/src
COPY core/pom.xml core
