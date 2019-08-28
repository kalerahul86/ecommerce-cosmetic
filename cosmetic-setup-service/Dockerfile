FROM openjdk:8
CMD ["mvn", "clean", "package"]
COPY ./target/cosmetic-setup-service-0.0.1-SNAPSHOT.jar /home/ecommerce-app/cosmetic-setup-service.jar
WORKDIR /home/ecommerce-app/
EXPOSE 8080
CMD ["java", "-jar", "cosmetic-setup-service.jar"]
