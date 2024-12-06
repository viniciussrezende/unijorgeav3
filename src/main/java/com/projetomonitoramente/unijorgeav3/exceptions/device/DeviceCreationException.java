package com.projetomonitoramente.unijorgeav3.exceptions.device;

public class DeviceCreationException extends RuntimeException {
  public DeviceCreationException(String message) {
    super(message);
  }

  public DeviceCreationException(String message, Throwable cause){
      super(message, cause);
  }
}
