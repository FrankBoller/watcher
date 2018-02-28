#!/bin/bash

args=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
jar=target/swagger-spring-1.0.0.1.jar

java ${args} -jar ${jar}

