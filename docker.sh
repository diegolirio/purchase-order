echo "mvn compile..."
mvn clean compile 

cp src/main/java/com/diegolirio/purchaseorder/reports/po.jrxml target/classes/com/diegolirio/purchaseorder/reports/
echo 'Copied'

echo "mvn package..."
mvn package -DskipTests=true

# targer/classes/com/diegolirio/purchaseorder/reports/po.jrxml

echo "Image Building..."
#docker build -t diegolirio/purchase-order:1.1 .
docker build -t registry.heroku.com/cafglass-pedido/web .

echo "docker push..."
docker push registry.heroku.com/cafglass-pedido/web

