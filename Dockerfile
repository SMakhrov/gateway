FROM centos:8

MAINTAINER Stanislav Makhrov

#RUN yum install -y java


RUN echo $'[mongodb-org-4.2] \n\
name            = MongoDB Repository \n\
baseurl         = https://repo.mongodb.org/yum/redhat/$releasever/mongodb-org/4.2/x86_64/ \n\
enabled         = 1 \n\
gpgcheck        = 1 \n\
gpgkey=https://www.mongodb.org/static/pgp/server-4.2.asc' > /etc/yum.repos.d/mongodb-org-4.2.repo

RUN yum install -y mongodb-org

#VOLUME /tmp
#ADD /target/gateway-1.0.jar gateway.jar
#RUN sh -c 'touch /gateway.jar'
#ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/gateway.jar"]