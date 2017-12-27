echo "######### EXCLUINDO TUDOOOOOOO ###########"
docker rm -f $(docker ps -a)

echo "######### Criando Rede Docker ###########"
docker network create --driver bridge purchase-order

sh ./create-mysql.sh

sh ./deploy.sh
