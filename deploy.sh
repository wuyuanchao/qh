mvn clean package
cd qh-controller
docker build --build-arg JAR_FILE=target/qh.jar -t core.devtest.com/default/qh:latest .
docker push core.devtest.com/default/qh:latest
