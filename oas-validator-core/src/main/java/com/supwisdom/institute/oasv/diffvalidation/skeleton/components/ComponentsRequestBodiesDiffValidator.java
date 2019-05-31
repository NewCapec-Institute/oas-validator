package com.supwisdom.institute.oasv.diffvalidation.skeleton.components;

import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.RequestBodyDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.REQUEST_BODY;

public class ComponentsRequestBodiesDiffValidator
  extends MapPropertyDiffValidator<Components, RequestBody>
  implements ComponentsDiffValidator {

  public ComponentsRequestBodiesDiffValidator(List<RequestBodyDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, RequestBody> getMapProperty(Components oasObject) {
    return oasObject.getRequestBodies();
  }

  @Override
  protected String getMapPropertyName() {
    return "requestBodies";
  }

  @Override
  protected OasObjectType getValueType() {
    return REQUEST_BODY;
  }
}
