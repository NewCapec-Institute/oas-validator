package com.supwisdom.institute.oasv.diffvalidation.skeleton.components;

import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.HeaderDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.headers.Header;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.HEADER;

public class ComponentsHeadersDiffValidator
  extends MapPropertyDiffValidator<Components, Header>
  implements ComponentsDiffValidator {

  public ComponentsHeadersDiffValidator(List<HeaderDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, Header> getMapProperty(Components oasObject) {
    return oasObject.getHeaders();
  }

  @Override
  protected String getMapPropertyName() {
    return "headers";
  }

  @Override
  protected OasObjectType getValueType() {
    return HEADER;
  }
}
