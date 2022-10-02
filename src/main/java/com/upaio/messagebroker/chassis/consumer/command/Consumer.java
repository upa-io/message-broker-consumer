package com.upaio.messagebroker.chassis.consumer.command;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.upaio.messagebroker.chassis.consumer.config.MessageBrokerConfiguration;
import com.upaio.messagebroker.chassis.consumer.model.ObjectMessageDTO;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = MessageBrokerConfiguration.QUEUE_NAME)
    public void consumeMessage(ObjectMessageDTO objectMessageDTO) {
        log.info("Consumed Message: " + objectMessageDTO);
        try {
            Thread.sleep(8 * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }
}
