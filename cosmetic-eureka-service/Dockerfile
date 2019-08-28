FROM openjdk:8
CMD ["mvn", "clean", "package"]
COPY ./target/cosmetic-eureka-service-0.0.1-SNAPSHOT.jar /home/ecommerce-app/cosmetic-eureka-service.jar
WORKDIR /home/ecommerce-app/
EXPOSE 8761
CMD ["java", "-jar", "cosmetic-eureka-service.jar"]
