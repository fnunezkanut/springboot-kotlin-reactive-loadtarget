FROM openjdk:8u191-jdk-alpine3.9
MAINTAINER https://github.com/fnunezkanut
EXPOSE 8080
VOLUME /tmp
ARG JAR_FILE=build/libs/springboot-kotlin-reactive-loadtarget.jar
ADD ${JAR_FILE} springboot-kotlin-reactive-loadtarget.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=default","-XX:+UnlockExperimentalVMOptions","-XX:+UseCGroupMemoryLimitForHeap","-XX:MaxRAMFraction=2","/springboot-kotlin-reactive-loadtarget.jar"]