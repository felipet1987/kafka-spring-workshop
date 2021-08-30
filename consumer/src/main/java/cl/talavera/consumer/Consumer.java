package cl.talavera.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @KafkaListener(topics = "test")
    public void listen(
            @Payload String message,
            @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition
    ){
        log.info(String.format("Received Message: %s from partition: %s ", message, partition));
    }

}
