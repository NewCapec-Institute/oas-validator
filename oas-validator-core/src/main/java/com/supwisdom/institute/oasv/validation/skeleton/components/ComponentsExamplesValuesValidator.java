package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ExampleValidator;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.examples.Example;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.EXAMPLE;

public class ComponentsExamplesValuesValidator extends MapPropertyValuesValidator<Components, Example>
  implements ComponentsValidator {

  public ComponentsExamplesValuesValidator(List<ExampleValidator> valueValidators) {
    super(valueValidators);
  }
  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }
  @Override
  protected Map<String, Example> getMapProperty(Components components) {
    return components.getExamples();
  }

  @Override
  protected String getMapPropertyName() {
    return "examples";
  }

  @Override
  protected OasObjectType getValueType() {
    return EXAMPLE;
  }

}
