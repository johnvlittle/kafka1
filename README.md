This project is a simple "hello world" spring boot confluent kafka app.

To run it:
1) move application.properties.clean to application.properties and edit the values to point to your kafka server.
2) use ./mvnw spring-boot:run

Source is taken directly from the confluent example and documentation.
The confluent kafka broker is up and running, and the connection details used in the application.properties file are correct becuse they work 
in the "offset exlorer" app.

However it doesnt work.  There are 2 issues:

1. intellij cant run the project.  If you hit the run arrow on main, it just gives this error: "java.lang.IllegalStateException: No Docker Compose file found in directory ".  however there is no docker in the project.
2. The project will run from the command line, but it doesnt work, no message is sent.   It doesnt seem to be reading the application.properties file.  The output is:

```
2024-02-24T21:46:05.870+01:00  INFO 97874 --- [           main] o.a.k.clients.producer.KafkaProducer     : [Producer clientId=producer-1] Instantiated an idempotent producer.
2024-02-24T21:46:05.886+01:00  INFO 97874 --- [           main] o.a.k.c.s.authenticator.AbstractLogin    : Successfully logged in.
2024-02-24T21:46:05.940+01:00  INFO 97874 --- [           main] o.a.k.clients.producer.ProducerConfig    : These configurations '[session.timeout.ms]' were supplied but are not used yet.
2024-02-24T21:46:05.941+01:00  INFO 97874 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka version: 3.6.1
2024-02-24T21:46:05.942+01:00  INFO 97874 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka commitId: 5e3c2b738d253ff5
2024-02-24T21:46:05.942+01:00  INFO 97874 --- [           main] o.a.kafka.common.utils.AppInfoParser     : Kafka startTimeMs: 1708807565941
2024-02-24T21:46:06.034+01:00  INFO 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Node -1 disconnected.
2024-02-24T21:46:06.034+01:00  WARN 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Connection to node -1 (localhost/127.0.0.1:9092) could not be established. Broker may not be available.
2024-02-24T21:46:06.035+01:00  WARN 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Bootstrap broker localhost:9092 (id: -1 rack: null) disconnected
2024-02-24T21:46:06.140+01:00  INFO 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Node -1 disconnected.
2024-02-24T21:46:06.140+01:00  WARN 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Connection to node -1 (localhost/127.0.0.1:9092) could not be established. Broker may not be available.
2024-02-24T21:46:06.140+01:00  WARN 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Bootstrap broker localhost:9092 (id: -1 rack: null) disconnected
2024-02-24T21:46:06.247+01:00  INFO 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Node -1 disconnected.
2024-02-24T21:46:06.247+01:00  WARN 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Connection to node -1 (localhost/127.0.0.1:9092) could not be established. Broker may not be available.
2024-02-24T21:46:06.247+01:00  WARN 97874 --- [ad | producer-1] org.apache.kafka.clients.NetworkClient   : [Producer clientId=producer-1] Bootstrap broker localhost:9092 (id: -1 rack: null) disconnected
```
