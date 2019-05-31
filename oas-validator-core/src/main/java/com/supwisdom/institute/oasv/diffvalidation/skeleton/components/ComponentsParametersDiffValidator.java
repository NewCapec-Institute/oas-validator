package com.supwisdom.institute.oasv.diffvalidation.skeleton.components;

import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ParameterDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.PARAMETER;

public class ComponentsParametersDiffValidator
  extends MapPropertyDiffValidator<Components, Parameter>
  implements ComponentsDiffValidator {

  public ComponentsParametersDiffValidator(List<ParameterDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, Parameter> getMapProperty(Components oasObject) {
    return oasObject.getParameters();
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
