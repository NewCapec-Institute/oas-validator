package com.supwisdom.institute.oasv.diffvalidation.skeleton.components;

import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ExampleDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.examples.Example;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.EXAMPLE;

public class ComponentsExamplesDiffValidator
  extends MapPropertyDiffValidator<Components, Example>
  implements ComponentsDiffValidator {

  public ComponentsExamplesDiffValidator(List<ExampleDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, Example> getMapProperty(Components oasObject) {
    return oasObject.getExamples();
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
