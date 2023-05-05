## 因为openjdk缺少字体，easyexcel导出的时候会有问题，所以换一个基础镜像
FROM frolvlad/alpine-java:jdk8-slim
ARG JAR_FILE
COPY ${JAR_FILE} qh.jar
ENTRYPOINT ["java","-jar","/qh.jar"]