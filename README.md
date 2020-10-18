# kafka-helloworld
a template setup for Kafka's Producer, Consumer in scala

## Quick run
```shell
docker-compose up
```
### sbt build
There are 2 folders for Producer and Consumer. Once the services are up, you can build the uber jar to run them.
```shell
# build producer
docker exec -it kafka-helloworld_kafka-producer_1 bash -c "cd producer && sbt assembly"
# build consumer
docker exec -it kafka-helloworld_kafka-consumer_1 bash -c "cd consumer && sbt assembly"
```
### run producer & consumer
Each has to run in a separated console

* Run Producer first
```shell
docker exec -it kafka-helloworld_kafka-producer_1 bash -c "scala producer/target/scala-2.11/init-scala-producer"
```
* Then run Consumer
```shell
# run consumer
docker exec -it kafak-helloworld_kafka_consumer_1 bash -c "scala consumer/target/scala-2.11/init-scala-consumer"
```

## setup
A simple pipeline with 1 producer, 1 broker & 1 consumer. You can utilize docker-compose to scale out services.

For example, to scale to 2 brokers
```shell
docker-compose up --scale kafka=2
```
