echo "######### Build App ###########"
mvn clean package -DskipTests=true

container=pedido

if sudo docker ps | awk -v container="container" 'NR>1{  ($(NF) == container )  }'; then
  echo "Stop and destroy $container"
  sudo docker stop "$container" && sudo docker rm -f "$container"
fi

echo "######### Criando Container P.O. ###########"
docker run -i -t -d -p 7000:8080 -v ~/docker/logs/pedido:/usr/local/tomcat/logs --link mysql-docker:pomysql --name $container --network purchase-order diegolirio/tomcat8:1.2 /bin/bash
# -v ~/docker/logs/pedido:/usr/local/tomcat/logs
# -v ~/docker/tomcat-pedido-webapp:/usr/local/tomcat/webapps

#docker exec -i $container bash -c "apt-get update"
#docker exec -i $container bash -c "apt-get install mysql-client -y"

#docker run -it --link pedido:mysql-docker --name mysql-docker -e MYSQL_ROOT_PASSWORD=root -d mysql/mysql-server:latest

echo "######### Realizando Deploy ###########"
docker cp target/pedido.war pedido:/usr/local/tomcat/webapps/

echo "######### Starting Tomcat... ###########"
docker exec -i $container bash -c "./bin/catalina.sh start"


