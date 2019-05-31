package com.supwisdom.institute.oasv.validation.skeleton.openapi;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.COMPONENTS;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .components(<a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#componentsObject">Components Object</a>)校验器
 */
public class OpenApiComponentsValidator extends ObjectPropertyValidator<OpenAPI, Components>
  implements OpenApiValidator {


  public OpenApiComponentsValidator(
    List<ComponentsValidator> componentsValidators) {
    super(componentsValidators);
  }

  @Override
  protected String get$ref(OpenAPI oasObject) {
    return null;
  }

  @Override
  protected Components getPropertyObject(OpenAPI oasObject) {
    return oasObject.getComponents();
  }

  @Override
  protected String getPropertyName() {
    return "components";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return COMPONENTS;
  }

}
