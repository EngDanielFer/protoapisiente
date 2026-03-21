FROM maven:3.9.6-eclipse-temurin-17 AS build
 
WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline -q
 
COPY src ./src
RUN mvn clean package -DskipTests -q

RUN ls -lh target/app.jar

FROM eclipse-temurin:17-jre-alpine
 
WORKDIR /app
 
RUN addgroup -S siente && adduser -S siente -G siente
USER siente
 
COPY --from=build /app/target/app.jar app.jar
 
EXPOSE 8000
 
ENTRYPOINT ["java", \
  "-Xmx400m", \
  "-Xms200m", \
  "-XX:+UseContainerSupport", \
  "-XX:MaxRAMPercentage=75.0", \
  "-Djava.security.egd=file:/dev/./urandom", \
  "-jar", "app.jar"]
 