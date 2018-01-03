FROM tomcat:8.0
MAINTAINER diegolirio.dl@gmail.com

#ENV MACHINE_LOCAL=192.168.49.164

#COPY ~/logs/pedido /usr/local/tomcat/logs/
#COPY ./target/pedido.war /usr/local/tomcat/webapps

RUN apt-get update && apt-get -y upgrade
RUN apt-get install xz-utils

RUN apt-get install mysql-client -y

RUN ./bin/catalina.sh start
 
# docker build -t diegolirio/tomcat8:1.1 .

