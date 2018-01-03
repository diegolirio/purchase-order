mvn clean package -DskipTests=true
#cp target/pedido.war 
docker-compose build
docker-compose up -d

echo "######### Realizando Deploy ###########"
docker cp target/pedido.war pedido:/usr/local/tomcat/webapps/
