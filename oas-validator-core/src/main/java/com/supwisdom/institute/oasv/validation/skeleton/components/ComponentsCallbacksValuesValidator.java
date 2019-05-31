package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.CallbackValidator;
import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.callbacks.Callback;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.CALLBACK;

public class ComponentsCallbacksValuesValidator extends MapPropertyValuesValidator<Components, Callback>
  implements ComponentsValidator {

  public ComponentsCallbacksValuesValidator(List<CallbackValidator> valueValidators) {
    super(valueValidators);
  }

  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }

  @Override
  protected Map<String, Callback> getMapProperty(Components components) {
    return components.getCallbacks();
  }

  @Override
  protected String getMapPropertyName() {
    return "callbacks";
  }

  @Override
  protected OasObjectType getValueType() {
    return CALLBACK;
  }

}
