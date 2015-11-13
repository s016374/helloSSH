FROM tomcat
ADD . /$CATALINA_HOME/webapp/
RUN mvn clean package
EXPOSE 8080
