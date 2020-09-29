import java.util.{Properties,Arrays}
import org.apache.kafka.clients.consumer.KafkaConsumer
import scala.collection.JavaConversions._

object ScalaConsumer extends App {
  val TOPIC = sys.env("TOPIC")

  val props = new Properties()
  props.put("bootstrap.servers", "kafka:9092")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("group.id", "Hello-World")

  println("Starting Kafka Consumer TOPIC test ....")
  val consumer = new KafkaConsumer[String, String](props)
  consumer.subscribe(Arrays.asList(TOPIC))
  while(true){
    val records = consumer.poll(100)
    for(re <- records.iterator()){
      println(re.key + " : " + re.value);
    }
  }
}
