FROM hub.c.163.com/library/java:openjdk-8u111-jdk-alpine
MAINTAINER wangp 704778688@qq.com
ADD ./target/guns-admin-1.0.0-SNAPSHOT.jar kjl-design.jar
EXPOSE 80
CMD ["java","-Xms256m","-Xmx1024m","-jar","/kjl-design.jar","--spring.profiles.active=prod"]