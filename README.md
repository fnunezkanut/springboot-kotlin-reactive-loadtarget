# Spring Boot Kotlin Reactive Loadtarget

Example reactive springboot microservice (in kotlin) which does nothing more than reply with random UUID to get requests.
Useful as a loadtesting target for other projects and as an example of a barebone sprinboot2 reactive project foundation

### Requirements
* JDK 1.8

### Developing locally:

* Use the spring profile called "dev" in IntelliJ, this cranks up logging output (see application-dev.properties file in resource directory)

### Building and running

```bash
#goto project root
cd ~/projects/springboot-kotlin-reactive-loadtarget/
./gradlew clean build
#when running locally
curl http://localhost:8080/uuid
#{
#  "dt" : "2019-02-10T12:31:52.921Z",
#  "uuid" : "ba06e350-a174-41d2-96f8-6adf295763f0"
#}
```


### Docker

```bash
#goto project root
cd ~/projects/springboot-kotlin-reactive-loadtarget/
#build image
docker build -t loadtarget .
#list images
docker images
#start a container
docker run -p 8080:8080 --memory 512M --memory-swap 512M -it loadtarget
```
