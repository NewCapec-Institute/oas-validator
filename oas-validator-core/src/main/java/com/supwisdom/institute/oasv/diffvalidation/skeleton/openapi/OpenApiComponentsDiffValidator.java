package com.supwisdom.institute.oasv.diffvalidation.skeleton.openapi;

import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OpenApiDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.COMPONENTS;

public class OpenApiComponentsDiffValidator
  extends ObjectPropertyDiffValidator<OpenAPI, Components>
  implements OpenApiDiffValidator {

  public OpenApiComponentsDiffValidator(
    List<ComponentsDiffValidator> componentsDiffValidators) {
    super(componentsDiffValidators);
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
