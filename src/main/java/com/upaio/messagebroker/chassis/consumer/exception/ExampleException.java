package com.upaio.messagebroker.chassis.consumer.exception;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;

public class ExampleException extends AmqpRejectAndDontRequeueException {
    /**
     * Construct an instance with the supplied argument.
     *
     * @param message A message describing the problem.
     */
    public ExampleException(String message) {
        super(message);
    }
}
