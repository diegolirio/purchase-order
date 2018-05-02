# purchase-order
----------------------------
Projeto desenvolvido com a linguagem Java, 
Java Web utilizando Spring MVC, 
Spring IoC/DI, Spring Transaction para controlar transações, 
Spring Data integrado com JPA/Hibernate na camada de persistência, 
Jasper e IReport para relatórios, Spring Mail, JavaMail e Apache Velocity para envio de emails.
AngularJS para programação front-end utilizando conceito restFull,
Banco de dados mysql, servidor Tomcat 7, JUnit para TDD, Maven para gerenciamento de dependencias.

### Build And push Image Docker to Registry
```
sudo ./docker.sh
```

### Deploy
```
cd deploy/
sudo ./deploy.sh dump
```

### Deploy in Cloud (Without jdk)
```
mkdir po_docker
cd po_docker
wget https://raw.githubusercontent.com/diegolirio/purchase-order/deploy-docker/deploy/deploy-in-cloud.sh
sudo ./deploy-in-cloud.sh
```
