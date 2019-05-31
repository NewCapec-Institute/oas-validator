package com.supwisdom.institute.oasv.diffvalidation.skeleton.components;

import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ResponseDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.RESPONSE;

public class ComponentsResponsesDiffValidator
  extends MapPropertyDiffValidator<Components, ApiResponse>
  implements ComponentsDiffValidator {

  public ComponentsResponsesDiffValidator(List<ResponseDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, ApiResponse> getMapProperty(Components oasObject) {
    return oasObject.getResponses();
  }

  @Override
  protected String getMapPropertyName() {
    return "responses";
  }

  @Override
  protected OasObjectType getValueType() {
    return RESPONSE;
  }
}
