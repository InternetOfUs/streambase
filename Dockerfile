#Dockerfile
FROM maven:3.6.0-jdk-8-alpine AS build

COPY jolt /tmp/jolt/
COPY pom.xml /usr/app/

RUN mvn -f /tmp/jolt/pom.xml install
RUN mvn -f /usr/app/pom.xml verify

COPY src /usr/app/src/

RUN mvn -f /usr/app/pom.xml \
          -DskipTests clean package && \
	   cp /usr/app/target/ilogbase-*.jar /docker-image.jar

FROM frolvlad/alpine-java:jdk8-slim
COPY --from=build /docker-image.jar /docker-image.jar
RUN sh -c 'touch /docker-image.jar' && apk update && apk add tzdata
ENV JAVA_OPTS="-Xmx1g"
ENV TZ=Europe/Rome
ENV PROFILE="prod"
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Dspring.profiles.active=$PROFILE -Djava.security.egd=file:/dev/./urandom -jar /docker-image.jar" ]