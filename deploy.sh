echo "1. Building..."
#mvn clean package -DskipTests=true

echo "2. Down containers..."
docker-compose down

echo "3. Building images..."
docker-compose build

echo "4. Up containers..."
docker-compose up -d

echo "5. Deploing..."
docker cp target/pedido.war pedido:/usr/local/tomcat/webapps/

echo "6. Change mode 777..."
chmod -R 777 ~/docker/

if [ "$1" = "dump" ]
then
	echo "7. Import dump..."
	sleep 15
	docker exec -i mysqlpo mysql -uroot -proot --database=purchase < pedido--mysql--dump.sql
	echo "dump OK!" 
fi

echo "DONE!!!!"