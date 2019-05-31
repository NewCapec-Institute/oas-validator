package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ResponseValidator;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.RESPONSE;

public class ComponentsResponsesValuesValidator extends MapPropertyValuesValidator<Components, ApiResponse>
  implements ComponentsValidator {

  public ComponentsResponsesValuesValidator(List<ResponseValidator> valueValidators) {
    super(valueValidators);
  }
  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }
  @Override
  protected Map<String, ApiResponse> getMapProperty(Components components) {
    return components.getResponses();
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
