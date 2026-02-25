# Usamos una imagen de Java 17 
FROM eclipse-temurin:17-jdk-jammy

# Exponemos el puerto de la app
EXPOSE 9090

COPY target/*.war app.war

# Comando de arranque
ENTRYPOINT ["java", "-jar", "/app.war"]
