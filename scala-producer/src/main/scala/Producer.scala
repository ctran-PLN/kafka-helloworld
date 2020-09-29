import java.util.Properties
import util.control.Breaks._

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

object ScalaProducer extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "kafka:9092")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer = new KafkaProducer[String, String](props)
  val TOPIC = sys.env("TOPIC")

  println("Starting producer ...")
  var i:Long = 0;
  while(true){
      val record = new ProducerRecord(TOPIC, "key", "Hello World " + i)
      i+=1
      producer.send(record)
      Thread.sleep(500);
  }
  producer.close()
}
