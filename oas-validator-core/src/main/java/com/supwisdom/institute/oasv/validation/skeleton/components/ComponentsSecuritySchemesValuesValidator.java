package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.SecuritySchemeValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.SECURITY_SCHEME;

public class ComponentsSecuritySchemesValuesValidator extends MapPropertyValuesValidator<Components, SecurityScheme>
  implements ComponentsValidator {

  public ComponentsSecuritySchemesValuesValidator(List<SecuritySchemeValidator> valueValidators) {
    super(valueValidators);
  }
  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }
  @Override
  protected Map<String, SecurityScheme> getMapProperty(Components components) {
    return components.getSecuritySchemes();
  }

  @Override
  protected String getMapPropertyName() {
    return "securitySchemes";
  }

  @Override
  protected OasObjectType getValueType() {
    return SECURITY_SCHEME;
  }

}
