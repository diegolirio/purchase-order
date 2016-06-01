# purchase-order
----------------------------

'
Projeto desenvolvido com a linguagem Java, 
Java Web utilizando Spring MVC, 
Spring IoC/DI, Spring Transaction para controlar transações, 
Spring Data integrado com JPA/Hibernate na camada de persistência, 
Jasper e IReport para relatórios, Spring Mail, JavaMail e Apache Velocity para envio de emails.
AngularJS para programação front-end utilizando conceito restFull,
Banco de dados mysql, servidor Tomcat 7, JUnit para TDD, Maven para gerenciamento de dependencias.
'

### Executar projeto em desenvolvimento

1. Rode o comando no mysql para criar o Banco
	- CREATE DATABASE PURCHASE;
	
2. Rode o Script no mysql que esta da pasta /deploy na raiz do projeto


### Deploy no openshift

1. Considerando que a aplicacao no openshift chama-se "pedido" e o servidor 
 devera conter as VAR de dependencias OPENSHIFT_MYSQL_DB_HOST e OPENSHIFT_MYSQL_DB_PORT
 
2. gere o .war do projeto, faca um clone do projeto do openshift e coloque o .war dentro da pasta /webapps

3. agora basta rodar os comandos abaixo: 
	$ git add . && git commit -m "deploy" && git push 
(obs: devera digitar o usuario e senha para fazer o deploy)


### Deploy em uma VPS

1.  