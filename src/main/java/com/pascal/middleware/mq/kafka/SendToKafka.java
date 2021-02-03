package com.pascal.middleware.mq.kafka;

import com.pascal.config.LoadConfig;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class SendToKafka {

    public static void send(String key, String message) {
        Properties properties = LoadConfig.getInstance().getProperties();
        Properties props = new Properties();
        //Assign localhost id
        props.put("bootstrap.servers", properties.getProperty("kafka_ip"));
        //Set acknowledgements for producer requests.
        props.put("acks", "all");
        //If the request fails, the producer can automatically retry,
        props.put("retries", 0);
        //Specify buffer size in config
        props.put("batch.size", 16384);
        //Reduce the no of requests less than 0
        props.put("linger.ms", 1);
        //The buffer.memory controls the total amount of memory available to the producer for buffering.
        props.put("buffer.memory", 33554432);
        props.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        String topicName = properties.getProperty("kafka_theme");
        producer.send(new ProducerRecord<String, String>(topicName, key, message));
        System.out.println("kafka send succeed & key======" + key);
    }

    public static void main(String[] args) {
        String message = "{\"beginTime\":\"2020-10-15 02:58:01\",\"collector\":\"containerCollectorJava\",\"data\":\"<?xml version=\\\"1.0\\\" encoding=\\\"GB2312\\\"?>\\n\\n<dc>\\n  <mo id=\\\"70e32d5ffcf44b12a2b8fa8f723fb7fe\\\">\\n    <inner_group type=\\\"ips_resoucepool\\\" keyfield=\\\"dataCenterId\\\">\\n      <mo caption=\\\"sh-resource-pool\\\">\\n        <attribute name=\\\"dataCenterId\\\" value=\\\"1001\\\"/>\\n        <attribute name=\\\"createDate\\\" value=\\\"\\\"/>\\n        <attribute name=\\\"appVo\\\" value=\\\"\\\"/>\\n        <attribute name=\\\"name\\\" value=\\\"sh-resource-pool\\\"/>\\n      </mo>\\n    </inner_group>\\n  </mo>\\n</dc>\\n\",\"endFlag\":1,\"endTime\":\"2020-10-15 02:58:01\",\"format\":\"stdxml\",\"message\":\"\",\"resources\":[],\"scheduleTime\":\"2020-10-15 15:16:18\",\"status\":0,\"taskId\":\"00000000\"}\n";
        String key = "202010151218_3rd:bpm_bpmNode1_res:containerPlatform_20201015151618666";
        String topic = "sysm-datafile";
        send(key, message);
    }

}
