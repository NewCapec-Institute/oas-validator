# INSTALLATION.MD



## Prerequisites


* Java 8
* Maven
* Docker



## Building

### Jar

```
mvn clean package
```


```
./mvnw clean package
```



### Docker

```
mvn clean package dockerfile:build
```



## Run

### Maven

```
mvn clean package spring-boot:run
```



### Java

```
java -jar ./oas-validator-web/target/oas-validator-web-exec.jar
```



### Docker

```
docker run -d \
  --name oas-validator-web \
  -p 8080:8080 \
  harbor.supwisdom.com/oas-validator/oas-validator-web:0.0.1-SNAPSHOT
```

