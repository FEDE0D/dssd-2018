#!/bin/bash

cd dssd-backend
mvn clean install -DskipTests
mvn spring-boot:run