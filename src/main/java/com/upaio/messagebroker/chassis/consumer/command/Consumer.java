package com.upaio.messagebroker.chassis.consumer.command;

import com.upaio.messagebroker.chassis.consumer.exception.ExampleException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import com.upaio.messagebroker.chassis.consumer.config.MessageBrokerConfiguration;
import com.upaio.messagebroker.chassis.consumer.model.ObjectMessageDTO;

import java.util.Random;

@Component
@Slf4j
public class Consumer {

    @RabbitListener(queues = MessageBrokerConfiguration.QUEUE_NAME)
    public void consumeMessage(ObjectMessageDTO objectMessageDTO) throws ExampleException {
        log.info("Consumed Message: {}", objectMessageDTO);
//        try {
//            Thread.sleep(8 * 1000);
//        } catch (InterruptedException ie) {
//            Thread.currentThread().interrupt();
//        }
        if (new Random().nextBoolean()) {
            throw new ExampleException("Error Generic " + objectMessageDTO.getMessage());
        }
    }

    @RabbitListener(queues = "myQueue.dead-letter.queue")
    public void consumeMessageDLQ(ObjectMessageDTO objectMessageDTO) {
        log.info("Consumed Message DLQ : " + objectMessageDTO);

    }
}
