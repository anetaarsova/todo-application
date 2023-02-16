# TODO Application with Spring Boot, Docker and PostgreSQL

### Getting Started

All Maven plugins and dependencies are available from [Maven Central](https://search.maven.org/). Please have installed

* Java version 17
* Spring boot 3.0.2
* JDK 19.0.1
* Maven 4.0.0
* Docker 4.16.3 

### Building

`mvn clean install`

### Creating Docker images

`docker compose -f docker-compose.yaml up --build -d`

### Images generated, verify up and running

```
docker ps

CONTAINER ID   IMAGE                     COMMAND                  CREATED       STATUS        PORTS                    NAMES
c554d175cf6f   todo-application:latest   "java -jar app.jar"      12 days ago   Up 45 hours   0.0.0.0:8080->8080/tcp   app
e55af641398f   postgres:15.1-alpine      "docker-entrypoint.s…"   13 days ago   Up 45 hours   0.0.0.0:5432->5432/tcp   db

```

### Stop docker container

```
docker stop c554d175cf6f
```

### Remove docker container

```
docker rm -f e55af641398f
```

### Swagger

http://localhost:8080/swagger-ui-custom.html
