package com.supwisdom.institute.oasv.validation.skeleton.openapi;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import com.supwisdom.institute.oasv.validation.api.PathsValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.PATHS;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .paths(<a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#pathsObject">Paths Object</a>)校验器
 */
public class OpenApiPathsValidator extends ObjectPropertyValidator<OpenAPI, Paths>
  implements OpenApiValidator {

  public OpenApiPathsValidator(List<PathsValidator> pathsValidators) {

    super(pathsValidators);
  }

  @Override
  protected String get$ref(OpenAPI oasObject) {
    return null;
  }

  @Override
  protected Paths getPropertyObject(OpenAPI oasObject) {
    return oasObject.getPaths();
  }

  @Override
  protected String getPropertyName() {
    return "paths";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return PATHS;
  }

}
