#!/bin/bash

cd dssd-backend
export MAVEN_OPTS="-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n"
mvn clean install -DskipTests
mvn spring-boot:run
