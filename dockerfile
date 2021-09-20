FROM openjdk:11

COPY target/RelacionesEntreTablas-0.0.1-SNAPSHOT.jar ejemploSeguridad.jar

CMD ["java", "-jar", "/ejemploSeguridad.jar"]