package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyKeysValidator;
import io.swagger.v3.oas.models.Components;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#componentsObject">Components Object</a>
 * .callbacks属性key校验器
 */
public class ComponentsCallbacksKeysValidator extends MapPropertyKeysValidator<Components>
  implements ComponentsValidator {

  public ComponentsCallbacksKeysValidator(Predicate<String> keyPredicate,
    Function<String, String> errorFunction) {
    super(keyPredicate, errorFunction);
  }

  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }

  @Override
  protected Map<String, ?> getMapProperty(Components components) {
    return components.getCallbacks();
  }

  @Override
  protected String getMapPropertyName() {
    return "callbacks";
  }

}
