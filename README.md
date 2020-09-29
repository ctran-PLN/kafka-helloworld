# kafka-helloworld
a template setup for Kafka's Producer, Consumer in scala

## setup
A simple pipeline with 1 producer, 1 broker & 1 consumer. You can utilize docker-compose to scale out services.

For example, to scale to 2 brokers
```shell
docker-compose up --scale kafka=2
```
