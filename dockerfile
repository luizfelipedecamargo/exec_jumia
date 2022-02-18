# step 1 - BE
FROM openjdk:8-jdk-alpine
ENV APP_DIR /src/jumia/target/
ENV APP jumia-0.0.1-SNAPSHOT.jar
WORKDIR ${APP_DIR}
RUN mvnw spring-boot:run
ENTRYPOINT ["java","-jar","jumia-0.0.1-SNAPSHOT.jar.jar"]
EXPOSE 8080

# step 2 - FE
FROM nginx:alpine
ENV APP_DIR /src/main/resources/webapp/angular
WORKDIR ${APP_DIR}
RUN npm start
EXPOSE 4200