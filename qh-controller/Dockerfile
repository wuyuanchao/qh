FROM openjdk:8-slim
ARG JAR_FILE
COPY ${JAR_FILE} qh.jar
ENTRYPOINT ["java","-jar","/qh.jar"]