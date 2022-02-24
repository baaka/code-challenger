# code-challenger

## Description
Web application for a programming competition game, that allows user to solve pre-defined challenges.
Uses [JDoodle Compiler API](https://jdoodle.com/compiler-api) for code compilation.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally
First, build project with following maven command:

```shell
mvn spring-boot:run
```

There are several ways to run the application on your local machine. One way is to execute the `main` method in
the `org.code.challenger.CodeChallengerApplication` class from your IDE.

Alternatively you can use
the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)
like so:

```shell
mvn spring-boot:run
```
