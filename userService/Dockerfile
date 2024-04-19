FROM tomcat:latest

RUN cp -R /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/

COPY ./*.war /usr/local/tomcat/webapps/

WORKDIR  /usr/local/tomcat/

RUN chmod +x *
EXPOSE 8080-8090
CMD ["/bin/bash", "-c",  "java -jar -Dspring.profiles.active=dev /usr/local/tomcat/webapps/userService-0.0.1-SNAPSHOT.war"]