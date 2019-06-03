FROM harbor.supwisdom.com/institute/openjdk:8-jre-alpine

ENV ENABLE_JMX_SSL=false
ENV JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=docker
ENV SPRING_PROFILES_ACTIVE=docker

ARG NAME
ARG VERSION
ARG JAR_FILE

LABEL name=$NAME \
      version=$VERSION

EXPOSE 8080

EXPOSE 8443

COPY --chown=java-app:java-app target/${JAR_FILE} /home/java-app/lib/app.jar
