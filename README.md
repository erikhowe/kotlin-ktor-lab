# Dynamic Website

## Summary
A dynamic blogging website with a persistent database for articles. Backend stack includes Ktor, the H2 database and the Exposed ORM. Frontend stack is singly the FreeMarker template engine. Uses the [Shadow plugin](https://github.com/johnrengelman/shadow) for [Gradle](https://gradle.org/) to generate a [fat/uber JAR](https://stackoverflow.com/questions/19150811/what-is-a-fat-jar) for deployment on AWS Elastic Beanstalk.

## Table of Contents

## Technologies and Languages

1. [Ktor 2.0.2](https://ktor.io/) ([Netty Engine](https://netty.io/))
2. [Exposed 0.36.2](https://github.com/JetBrains/Exposed)
3. [H2 1.4.2](https://h2database.com/html/main.html)
4. [FreeMarker 2.3.31](https://freemarker.apache.org/)
5. [AWS Elastic Beanstalk](https://aws.amazon.com/elasticbeanstalk/)
6. [Kotlin 1.7.0](https://kotlinlang.org/)

## Local Deployment

`git clone https://github.com/erikhowe/kotlin-ktor-lab.git`

`cd kotlin-ktor-lab`

`./gradlew run`

`open http:localhost:5000`

## Cloud deployment

Generate a fat JAR in the lib directory with the Shadow plugin using the following command

`.gradlew shadowJar`

Create an application on AWS Elastic Beanstalk using the generated fat JAR


## Personal Notes
Kotlin data class - class whose main purpose is to hold data
compiler automatically derives equals(), toString(), componentN(), and copy() from the primary constructor

Control shift p to examine types of the object which are all of type column for sql

Data access object - pattern that provides an interface to a database without exposing the details of the specific database

EngineMain starts a server with the selected engine and loads the application module specified in the external application.conf file. Besides modules to load, this file can include various server parameters

A Ktor application can be run and deployed inside servlet containers that include Tomcat and Jetty. To deploy inside a servlet container, you need to generate a WAR archive and then deploy it to a server or a cloud service that supports WARs.

https://ktor.io/docs/elastic-beanstalk.html

Ktor provides a special testing engine that doesn't create a web server, doesn't bind to sockets, and doesn't make any real HTTP requests. Instead, it hooks directly into internal mechanisms and processes an application call directly. This results in quicker tests execution compared to running a complete web server for testing.

## Testing Notes

Use the testApplication function to set up a configured instance of a test application running locally.