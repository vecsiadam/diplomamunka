FROM openjdk:11
COPY war/chat-1.0.0-SNAPSHOT.war /usr/app/
WORKDIR /usr/app
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "chat-1.0.0-SNAPSHOT.war"]