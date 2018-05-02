echo "mvn package..."
mvn clean package -DskipTests=true

echo "Image Building..."
docker build -t registry.phoenix4go.com/purchase-order:1.0 .

echo "docker push..."
docker push registry.phoenix4go.com/purchase-order:1.0

