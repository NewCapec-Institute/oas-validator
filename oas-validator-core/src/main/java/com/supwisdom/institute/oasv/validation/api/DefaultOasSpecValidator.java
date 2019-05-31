package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import io.swagger.v3.oas.models.OpenAPI;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class DefaultOasSpecValidator implements OasSpecValidator {

  private List<OpenApiValidator> openApiValidators;

  public DefaultOasSpecValidator(List<OpenApiValidator> openApiValidators) {
    this.openApiValidators = openApiValidators;
  }

  @Override
  public List<OasViolation> validate(OasValidationContext context, OpenAPI openAPI) {

    OasObjectPropertyLocation location = OasObjectPropertyLocation.root();

    return openApiValidators
      .stream()
      .map(validator -> validator.validate(context, location, openAPI))
      .flatMap(list -> list.stream())
      .collect(toList());

  }
}
