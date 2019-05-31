package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.ParameterValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.PARAMETER;

public class ComponentsParametersValuesValidator extends MapPropertyValuesValidator<Components, Parameter>
  implements ComponentsValidator {

  public ComponentsParametersValuesValidator(List<ParameterValidator> valueValidators) {
    super(valueValidators);
  }
  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }
  @Override
  protected Map<String, Parameter> getMapProperty(Components components) {
    return components.getParameters();
  }

  @Override
  protected String getMapPropertyName() {
    return "parameters";
  }

  @Override
  protected OasObjectType getValueType() {
    return PARAMETER;
  }

}
