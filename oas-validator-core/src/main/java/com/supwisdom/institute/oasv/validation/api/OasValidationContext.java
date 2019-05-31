package com.supwisdom.institute.oasv.validation.api;

import io.swagger.v3.oas.models.OpenAPI;

import java.util.HashMap;
import java.util.Map;

public class OasValidationContext {

  private final OpenAPI openAPI;

  private final Map<String, Object> attributes = new HashMap<>();

  public OasValidationContext(OpenAPI openAPI) {
    this.openAPI = openAPI;
  }

  public OpenAPI getOpenAPI() {
    return openAPI;
  }

  public <T> T getAttribute(String name) {
    return (T) attributes.get(name);
  }

  public <T> void setAttribute(String name, T attr) {
    this.attributes.put(name, attr);
  }

}
