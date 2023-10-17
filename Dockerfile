FROM maven:3.9.4-amazoncorretto-21-debian
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B dependency:go-offline
#RUN mvn package
#CMD ["java", "-jar", "target/app.jar"]
CMD ["mvn", "spring-boot:run"]