package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyKeysValidator;
import io.swagger.v3.oas.models.Components;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

public class ComponentsSecuritySchemesKeysValidator extends MapPropertyKeysValidator<Components>
  implements ComponentsValidator {

  public ComponentsSecuritySchemesKeysValidator(Predicate<String> keyPredicate,
    Function<String, String> errorFunction) {
    super(keyPredicate, errorFunction);
  }
  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }
  @Override
  protected Map<String, ?> getMapProperty(Components components) {
    return components.getSecuritySchemes();
  }

  @Override
  protected String getMapPropertyName() {
    return "securitySchemes";
  }

}
