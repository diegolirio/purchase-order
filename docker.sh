echo "mvn compile..."
mvn clean compile 

cp src/main/java/com/diegolirio/purchaseorder/reports/po.jrxml target/classes/com/diegolirio/purchaseorder/reports/
echo 'Copied'

echo "mvn package..."
mvn package -DskipTests=true

# targer/classes/com/diegolirio/purchaseorder/reports/po.jrxml

echo "Image Building..."
docker build -t registry.phoenix4go.com/purchase-order:1.0 .

echo "docker push..."
docker push registry.phoenix4go.com/purchase-order:1.0

