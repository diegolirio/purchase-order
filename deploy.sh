echo "Building...."
mvn clean package

chmod -R 777 ~/docker/webapps/pedido/

echo "Deploying...."
cp target/pedido.war ~/docker/webapps/pedido/

echo "Removing containers..."
docker-compose down

echo "Creating containers..."
docker-compose up -d

docker exec -i pedido bash -c "./bin/catalina.sh start"

if [ "$1" = "dump" ]
then
    echo "Run mysqldump..."
    ls
    docker exec -i mysqlpo bash -c 'mysql -upo -ppo3030 --database=purchase < pedido--mysql--dump.sql'
fi

echo "DONE!!!!"



### Rode na mao o comando abaixo para o primeiro deploy ######

# docker exec -i mysqlpo mysql -upo -ppo3030 --database=purchase < dump/pedido--mysql--dump.sql
# docker exec -i pedido ./bin/catalina.sh start
