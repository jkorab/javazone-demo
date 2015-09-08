# javazone-demo
## Sample project for "Winning Integration Architectures with Apache Camel"

This project demonstrates the use of `camel-spring-boot` (http://camel.apache.org/spring-boot) for developing standalone integrations, and enables the use of the HawtIO console (http://hawt.io) to get an insight into those integrations at runtime.

The classes contained here are as follows:

* `com.ameliant.javazone.CamelSpringBootDemoApplication` - a main class that performs the Camel bootstrapping.
* `com.ameliant.javazone.ApplicationConfig` - a Spring `@Configuration` class that sets up an ActiveMQ component for use by Camel against an embedded ActiveMQ broker (defined by the `brokerURL` property in `/resources/application.properties`).
* `com.ameliant.javazone.routes.JmsBridgeRoute` - a JMS bridge that selectively transforms payloads based on JMS message headers.
* `com.ameliant.javazone.routes.PingTimerRoute` - a test driver (diabled on startup), which pushes sample messages into a source queue for consumption by the `JmsBridgeRoute`.

The Maven `pom.xml` file defines dependencies on the starter JARs required to enable Spring Boot.

To start the application, execute `mvn spring-boot:run` from the command line.

If you get port conflicts at startup, make sure that there is nothing running on the port 8080.

To use HawtIO, download the command-line executable version of the library from the project's downloads page and run the following command:

`java -jar hawtio-app-<version>.jar --port 8081`

A browser window should open taking you to http://localhost:8081/hawtio/welcome

To connect to the sample app, use the following settings in the `Connect` tab:

* host: localhost
* port: 8080
* path: jolokia

Happy Camel Riding!

## Need assistance with Apache Camel?

Ameliant is a specialist consultancy based in Bristol, UK that offers Apache Camel, ActiveMQ, and also Apache ServiceMix and JBoss Fuse consulting.
As well as helping teams get integration projects going on the right track (and keeping them there),
we deliver commercial training courses that are open-admission, which can be tailored specifically to your team's needs and taught on-site.

* http://ameliant.com/camel
* http://ameliant.com/training

For teams in/near Norway, we run regular open-enrolment Apache Camel training sessions in Oslo via Bouvet Training:

* http://j.mp/camel-training-oslo

For individual technical questions around Apache Camel, the best places to ask are:

* http://camel.465427.n5.nabble.com/Camel-Users-f465428.html - the official Apache Camel users mailing list on Nabble
* http://stackoverflow.com - chock full of helpful people including Camel committers
