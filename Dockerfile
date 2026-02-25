# Usamos una base ligera de Java 17 
FROM openjdk:17-jdk-slim

# Exponemos el puerto 9090 que configuramos en el properties
EXPOSE 9090

COPY target/*.war app.war

# Comando para arrancar la aplicación
ENTRYPOINT ["java", "-jar", "/app.war"]
