package com.supwisdom.institute.oasv.diffvalidation.skeleton.openapi;

import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OpenApiDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.PathsDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Paths;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.PATHS;

public class OpenApiPathsDiffValidator
  extends ObjectPropertyDiffValidator<OpenAPI, Paths>
  implements OpenApiDiffValidator {

  public OpenApiPathsDiffValidator(List<PathsDiffValidator> pathsDiffValidators) {
    super(pathsDiffValidators);
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
