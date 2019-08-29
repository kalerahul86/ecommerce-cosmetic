FROM adoptopenjdk/maven-openjdk8
COPY ./ /home/ecommerce-app/cosmetic-setup-service
WORKDIR /home/ecommerce-app/cosmetic-setup-service/
EXPOSE 8080
RUN mvn clean package
CMD ["java", "-jar", "./target/cosmetic-setup-service-0.0.1-SNAPSHOT.jar"]
