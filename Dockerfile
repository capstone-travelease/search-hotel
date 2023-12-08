FROM openjdk:21

VOLUME /tmp

COPY target/*.jar demo-0.0.1-SNAPSHOT.jar

EXPOSE 9089
ENTRYPOINT ["java","-jar","/search_hotel-0.0.1-SNAPSHOT.jar"]