mvn clean package -DskipTests=true
#cp target/pedido.war 
docker-compose build
docker-compose up -d
