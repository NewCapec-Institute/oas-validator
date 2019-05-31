package com.supwisdom.institute.oasv.util;

public class OasSpecParseException extends RuntimeException {
  public OasSpecParseException() {
  }

  public OasSpecParseException(String message) {
    super(message);
  }

  public OasSpecParseException(String message, Throwable cause) {
    super(message, cause);
  }

  public OasSpecParseException(Throwable cause) {
    super(cause);
  }

  public OasSpecParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
