package com.supwisdom.institute.oasv.diffvalidation.skeleton.openapi;

import com.supwisdom.institute.oasv.diffvalidation.api.InfoDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OpenApiDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.INFO;

public class OpenApiInfoDiffValidator
  extends ObjectPropertyDiffValidator<OpenAPI, Info>
  implements OpenApiDiffValidator {

  public OpenApiInfoDiffValidator(List<InfoDiffValidator> pathsDiffValidators) {
    super(pathsDiffValidators);
  }

  @Override
  protected Info getPropertyObject(OpenAPI oasObject) {
    return oasObject.getInfo();
  }

  @Override
  protected String getPropertyName() {
    return "info";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return INFO;
  }

}
