FROM  tomcat:8.0

ADD target/pedido.war /usr/local/tomcat/webapps/

EXPOSE 8080