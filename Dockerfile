FROM openjdk:17
WORKDIR /app
COPY ./target/BootMVCProj09-MiniProject-0.0.1-SNAPSHOT.jar /app
EXPOSE 4041
CMD ["java", "-jar", "BootMVCProj09-MiniProject-0.0.1-SNAPSHOT.jar"]