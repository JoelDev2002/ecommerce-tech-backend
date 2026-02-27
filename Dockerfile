 #Imagen con Java 17
FROM eclipse-temurin:17-jdk

# Carpeta de trabajo
WORKDIR /app

# Copiamos todo el proyecto
COPY . .

# Construimos el proyecto
RUN ./mvnw clean package -DskipTests

# Ejecutamos el jar
CMD ["java", "-jar", "target/*.jar"]