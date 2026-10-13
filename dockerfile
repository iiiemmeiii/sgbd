# --- Build et lancement de l'application ---
FROM maven:3.9-eclipse-temurin-25

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src

EXPOSE 8080

CMD ["sh", "-c", "mvn -B package dependency:copy-dependencies -DoutputDirectory=target/dependency && java -cp 'target/ProjectName-1.0-SNAPSHOT.jar:target/dependency/*' sgbdproj.Connexion"]