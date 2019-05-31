package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import io.swagger.v3.oas.models.OpenAPI;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class DefaultOasSpecDiffValidator implements OasSpecDiffValidator {

  private final List<OpenApiDiffValidator> openApiDiffValidators;

  public DefaultOasSpecDiffValidator(List<OpenApiDiffValidator> openApiDiffValidators) {
    this.openApiDiffValidators = new ArrayList<>(openApiDiffValidators);
  }

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context, OpenAPI leftOpenApi, OpenAPI rightOpenApi) {

    OasObjectPropertyLocation leftRoot = OasObjectPropertyLocation.root();
    OasObjectPropertyLocation rightRoot = OasObjectPropertyLocation.root();

    return openApiDiffValidators
      .stream()
      .map(validator -> validator.validate(context, leftRoot, leftOpenApi, rightRoot, rightOpenApi))
      .flatMap(list -> list.stream())
      .collect(toList());
  }

}
