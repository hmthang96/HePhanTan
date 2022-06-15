FROM openjdk:8
VOLUME /tmp
EXPOSE 8007
ADD ./target/springboot-microservice-manage-student-0.0.1-SNAPSHOT.jar microservice-student.jar
ENTRYPOINT ["java","-jar","/microservice-student.jar"]