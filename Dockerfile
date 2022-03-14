FROM maven:3.6-jdk-8-alpine
COPY pom.xml /app/
COPY src /app/src
RUN cd /app && mvn -e -B package -Plocal
ENTRYPOINT ["java", "-jar", "/app/target/connector-mq-elk-crep-0.0.1-SNAPSHOT.jar"]
EXPOSE 8090

#usar solo jar
