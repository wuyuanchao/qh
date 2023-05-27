mvn clean package
docker build --build-arg JAR_FILE=target/qh.jar -t core.devtest.com/default/qh:latest .
docker push core.devtest.com/default/qh:latest
#docker tag core.devtest.com/default/qh:latest qhdocker2023/qh:230521
#docker push qhdocker2023/qh:230521
