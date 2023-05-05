## 因为openjdk缺少字体，easyexcel导出的时候会有问题，所以换一个基础镜像
FROM frolvlad/alpine-java:jdk8-slim
ARG JAR_FILE
COPY ${JAR_FILE} qh.jar

# 设置时区为东八区
RUN apk add --no-cache tzdata && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" > /etc/timezone && \
    apk del tzdata

ENTRYPOINT ["java","-jar","/qh.jar"]