# purchase-order
----------------------------
Projeto desenvolvido com a linguagem Java, 
Java Web utilizando Spring MVC, 
Spring IoC/DI, Spring Transaction para controlar transações, 
Spring Data integrado com JPA/Hibernate na camada de persistência, 
Jasper e IReport para relatórios, Spring Mail, JavaMail e Apache Velocity para envio de emails.
AngularJS para programação front-end utilizando conceito restFull,
Banco de dados mysql, servidor Tomcat 7, JUnit para TDD, Maven para gerenciamento de dependencias.



# Run In Docker 
```
sudo ./init.sh
```
CREATE USERS
```
sudo docker exec -it mysql-docker bash
mysql -uroot -proot 
CREATE DATABASE purchase
CREATE USER 'po'@'%' IDENTIFIED BY 'po123'
GRANT ALL PRIVILEGES ON *.* TO 'po'@'%' WITH GRANT OPTION;
```