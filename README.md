# qh

qh xun-jia

TRY PULL REQUESTS


#### 连接远程(执御的，需要vpn)docker进程

```shell script
export DOCKER_HOST=tcp://172.31.0.129:2375
docker ps
```

#### 手动打镜像
```shell script
cd qh-controller
docker build --build-arg JAR_FILE=target/qh.jar -t core.devtest.com/default/qh:latest .
```

#### 上传镜像文件
```shell script
docker push core.devtest.com/default/qh:latest
```