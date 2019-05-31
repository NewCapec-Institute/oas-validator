package com.supwisdom.institute.oasv.diffvalidation.api;

import io.swagger.v3.oas.models.OpenAPI;

import java.util.HashMap;
import java.util.Map;

public class OasDiffValidationContext {

  private final OpenAPI leftOpenAPI;

  private final OpenAPI rightOpenAPI;

  private final Map<String, Object> attributes = new HashMap<>();

  public OasDiffValidationContext(OpenAPI leftOpenAPI, OpenAPI rightOpenAPI) {
    this.leftOpenAPI = leftOpenAPI;
    this.rightOpenAPI = rightOpenAPI;
  }

  public OpenAPI getLeftOpenAPI() {
    return leftOpenAPI;
  }

  public OpenAPI getRightOpenAPI() {
    return rightOpenAPI;
  }

  public <T> T getAttribute(String name) {
    return (T) attributes.get(name);
  }

  public <T> void setAttribute(String name, T attr) {
    this.attributes.put(name, attr);
  }

  public void removeAttribute(String name) {
    this.attributes.remove(name);
  }

}
