package com.upaio.messagebroker.chassis.consumer.model;

import lombok.Data;
import java.io.Serial;
import java.io.Serializable;

@Data
public class ObjectMessageDTO implements Serializable {
  
  @Serial
  private static final long serialVersionUID = 9091314113317626180L;
  private String message;
  private String anotherMessage;

}
