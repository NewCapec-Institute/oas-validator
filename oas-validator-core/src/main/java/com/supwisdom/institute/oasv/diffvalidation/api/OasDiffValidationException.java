package com.supwisdom.institute.oasv.diffvalidation.api;

public class OasDiffValidationException extends RuntimeException {
  public OasDiffValidationException() {
  }

  public OasDiffValidationException(String message) {
    super(message);
  }

  public OasDiffValidationException(String message, Throwable cause) {
    super(message, cause);
  }

  public OasDiffValidationException(Throwable cause) {
    super(cause);
  }

  public OasDiffValidationException(String message, Throwable cause, boolean enableSuppression,
    boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
