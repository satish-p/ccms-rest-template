## Introduction
This is a walking skeleton used to create REST based micro-services.

Features

* Gradle project
* Plain / executable war
* Unit Tests
* Integration tests
* Metrics & Health
* Code Quality & Coverage Analysis with SonarQube
* Caching abstraction with ehcache caching provider
* Automatic Swagger Documentation Generation Framework
* Create Docker images
* Upload to Docker repository
* Starter JMeter scripts
* Kick Start Jenkins CI/CD Pipeline
 
## What you'll need
JDK 1.8. 

That's it. You do not need to install gradle, tomcat or any other software. You can install and run with it if you want to. But why bother... This is much cleaner and future friendly.

## Generate IDE settings
Eclipse

```
sh gradlew eclipse
```

Intellij IDEA

```
sh gradlew idea
```


## Build the app
All you need to build the app is JDK8. Install it and then simply run the following

```
sh gradlew build
```

## Run the app
The build process creates an executable war file. So you can run the web app

```
java -jar build/lib/resttemplate.war
```

or

```
sh gradlew bootRun
```

## Unit Tests
All unit tests are in src/test/java directory. These tests are designed run fast with mocks and/or stubs. To run the unit tests

```
sh gradlew test
```

The command will generate unit test reports in a nice html format you can look at and check for any errors in build/reports/tests/index.html
 

## Integration Tests
All integration tests are in src/integrationtest/java directory. These tests are designed to interact with remote servers or databases. To run the integrations tests

```
sh gradlew integrationTest
```

## Metrics and health 
The application exposes multiple metrics about itself at run time.

### Javamelody
The application exposes various metrics about itself such as requests, errors, memory, cpu, threads, gc usage at uri /monitoring

### Spring Boot Actuator
The application support spring boot actuator metrics

/manage/env - The environment variables, startup parameters etc
/manage/health - Health indicator of the application
/manage/metrics - Metrics of the application

## Code Quality & Coverage Analysis
There are many tools used for code quality analysis of this project such as Checkstyle, Pmd, FindBugs, Jacoco. Gradle and SonarQube makes it simple by running all the analysis and uploading the results to SonarQube. The following command will do that for you.
 
```
sh gradlew sonarRunner
```

## Caching abstraction
The application has framework to support caching abstraction using spring caching. The implementation is ehcache by default. This can easily be changed by updating the configuration to use other providers such as memcached, redis, etc..

Here's a simple code that enables caching in the service layer without dealing with the actual implementation

```java
    @Cacheable("products")
    public ProductSummary getProductSummary(String id, String view) {
        Product product = catalogDao.getProduct(id);
        if(product==null) {
            throw new DataNotFoundException(String.format("Unable to find product '%s' details", id));
        }
        return new ProductSummary(product, getViewAttributes(view));
    }

```

## Swagger API document generation
The application supports autogeneration of API docmentation for end user to use. This keeps the documentation in sync with the code.

Example of documentatin generation for a uri is

```java
@Api(value="Catalog API", description="Catalog API")
public class CatalogController {
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ProductSummary getProduct(
            @ApiParam(required=true)
            @PathVariable("id") final String id,
            @ApiParam("Catalog attributes view. Ex: benefits-desktop, gathr")
            @RequestParam(value="view", required=false) String view) {
        ...
    }
}
```

## Docker image generation
The distDocker task automatically generates a docker image and uploads it to docker registry of your choice. The docker task is in gradle/docker.gradle if you want to tweak any functionality.

Generating and uploading the image is as simple as

```
sh gradlew distDocker
```

Running the docker image on any *nix server becomes quite simple.

```
docker run docker.obi.aol.com/cmitemplate:1.0.0
```

## JMeter tests
Sample jmeter scripts can be found in src/tests/jmeter directory. The scripts can either be run in UI mode or command line mode with the following command.

```
jmeter  -n \
        -t RestTemplate.jmx \
        -l RestTemplate.jtl \
        -j RestTemplate.jmx.log \
        -Jhost=localhost -Jport=8080 -Jprotocol=http
```

## Kick Start Jenkins CI/CD Pipeline
The jobs required to create a Jenkins pipeline are included in the /src/main/jenkins directory. Copy the jobs into ${JENKINS_HOME}/jobs directory and restart Jenkins. You should see the pipeline.

Configure Jenkins Server with JDK8, Git and install the following plugins to get started

* Build Pipeline
* Build Name Setter
* Clone workspace SCM
* Copy Artifact
* Email Extension
* GIT plugin
* Gradle plugin 
* Parametrized Trigger plugin
* PMD
* Performance plugin

