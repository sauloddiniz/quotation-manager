FROM openjdk:13-alpine3.10
ADD /target/quotation-manager-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8081:8081
ENTRYPOINT ["java", "-jar", "app.jar"]