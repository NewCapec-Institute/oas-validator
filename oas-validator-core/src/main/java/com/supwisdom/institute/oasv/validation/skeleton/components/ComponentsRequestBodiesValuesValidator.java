package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.RequestBodyValidator;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.REQUEST_BODY;

public class ComponentsRequestBodiesValuesValidator extends MapPropertyValuesValidator<Components, RequestBody>
  implements ComponentsValidator {

  public ComponentsRequestBodiesValuesValidator(List<RequestBodyValidator> valueValidators) {
    super(valueValidators);
  }
  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }
  @Override
  protected Map<String, RequestBody> getMapProperty(Components components) {
    return components.getRequestBodies();
  }

  @Override
  protected String getMapPropertyName() {
    return "requestBodies";
  }

  @Override
  protected OasObjectType getValueType() {
    return REQUEST_BODY;
  }

}
