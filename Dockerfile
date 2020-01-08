
FROM openjdk:latest
COPY ./target/ex-1.0-SNAPSHOT.jar ex-1.0-SNAPSHOT.jar
CMD ["java","-jar","ex-1.0-SNAPSHOT.jar"]

