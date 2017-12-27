container=mysql-docker

echo "######### Criando container MySQL ###########"
docker run -it --link pedido:apppedido --name $container --network purchase-order -v ~/docker/mysqlpo:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=root -d mysql/mysql-server:latest
#docker exec -it mysql-docker bash

docker exec -i $container bash -c "mysql --version"
docker exec -i $container bash -c "mysql -uroot -proot -e 'CREATE DATABASE purchase'"
#docker exec -i $container bash -c "mysql -uroot -proot -e 'CREATE USER 'po'@'%' IDENTIFIED BY 'po123';"
#docker exec -i $container bash -c "mysql -uroot -proot -e  'GRANT ALL PRIVILEGES ON *.* TO 'po'@'%' WITH GRANT OPTION';"

# Com App Docker pedido
# mysql -upo -ppo123 -hmysql-docker -e 'CREATE DATABASE purchase'
# mysql -upo -ppo123 -hmysql-docker -e 'CREATE DATABASE purchase'

# CREATE USER 'po'@'%' IDENTIFIED BY 'po123'; 
# GRANT ALL PRIVILEGES ON *.* TO 'po'@'%' WITH GRANT OPTION;

# Export Dump
# docker exec mysql-docker sh -c 'exec mysqldump --all-databases -uroot -p"$MYSQL_ROOT_PASSWORD"' > ./dev/pedido_20170704.sql
