FROM maven:3.8-jdk-11 as maven_build
WORKDIR /app

#copy source
COPY backend/controller/src ./backend/controller/src
COPY backend/entity/src ./backend/entity/src
COPY backend/repository/src ./backend/repository/src
COPY backend/security/src ./backend/security/src
COPY backend/service/src ./backend/service/src

#copy poms
COPY backend/controller/pom.xml ./backend/controller
COPY backend/entity/pom.xml ./backend/entity
COPY backend/repository/pom.xml ./backend/repository
COPY backend/security/pom.xml ./backend/security
COPY backend/service/pom.xml ./backend/service
COPY backend/pom.xml ./backend
COPY pom.xml .

#resolve maven dependencies, select settings and profile
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r backend/controller/target/

# build the app (no dependency download here)
RUN mvn clean package  -Dmaven.test.skip

# split the built app into multiple layers to improve layer rebuild
RUN mkdir -p target/docker-packaging && cd target/docker-packaging && jar -xf /app/backend/controller/target/controller*.jar

FROM openjdk:11.0-jre

WORKDIR /app

COPY --from=maven_build /app/backend/controller/target/controller*.jar .

CMD [ "java", "-jar","./controller.jar" ]

EXPOSE 8080:8080


