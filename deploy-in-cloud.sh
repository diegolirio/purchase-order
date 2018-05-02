mkdir po_docker
cd po_docker
wget https://raw.githubusercontent.com/diegolirio/purchase-order/deploy-docker/deploy/deploy.sh
wget https://raw.githubusercontent.com/diegolirio/purchase-order/deploy-docker/deploy/docker-compose.yml
wget https://raw.githubusercontent.com/diegolirio/purchase-order/deploy-docker/deploy/pedido--mysql--dump-16042018.sql

chmod 777 deploy.sh 
sudo ./deploy.sh 
# Ou para executar com dump no DB --> sudo ./deploy.sh dump
