FROM openjdk:8
CMD ["mvn", "clean", "package"]
COPY ./target/transaction-service-0.0.1-SNAPSHOT.jar /home/ecommerce-app/transaction-service.jar
WORKDIR /home/ecommerce-app/
EXPOSE 8081
CMD ["java", "-jar", "transaction-service.jar"]
