# NAO ATIVADO

FROM mysql:5.7
MAINTAINER diegolirio.dl@gmail.com

#RUN /bin/bash -c mysql -u root -e "CREATE DATABASE purchase" && \
#  mysql -u root purchase < /tmp/dump.sql

#RUN mysql -u root purchase < ./script.sql

#ENV MYSQL_ROOT_PASSWORD root

#RUN mkdir /sql
#RUN	chmod 644 /sql

#ADD ["./script.sql", "/sql/sources.sql"]

#RUN /etc/init.d/mysql start && \
#    mysql -u root -p${MYSQL_ROOT_PASSWORD} -e "CREATE DATABASE lba" && \
#    	mysql -u root -p${MYSQL_ROOT_PASSWORD} -D lba < /usr/sql/sources.sql && \
#    	rm -rd /usr/sql && \

#RUN mysql -u root -proot -e 'CREATE DATABASE ppppp'