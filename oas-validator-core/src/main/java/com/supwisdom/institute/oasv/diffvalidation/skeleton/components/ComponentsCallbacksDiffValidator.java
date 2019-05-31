package com.supwisdom.institute.oasv.diffvalidation.skeleton.components;

import com.supwisdom.institute.oasv.diffvalidation.api.CallbackDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.callbacks.Callback;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.CALLBACK;

public class ComponentsCallbacksDiffValidator
  extends MapPropertyDiffValidator<Components, Callback>
  implements ComponentsDiffValidator {

  public ComponentsCallbacksDiffValidator(List<CallbackDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, Callback> getMapProperty(Components oasObject) {
    return oasObject.getCallbacks();
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
