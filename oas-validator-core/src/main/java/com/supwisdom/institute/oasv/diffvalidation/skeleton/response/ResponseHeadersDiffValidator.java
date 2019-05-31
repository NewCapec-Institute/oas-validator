package com.supwisdom.institute.oasv.diffvalidation.skeleton.response;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.HEADER;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.enterResponse;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.leaveResponse;

public class ResponseHeadersDiffValidator
  extends MapPropertyDiffValidator<ApiResponse, Header>
  implements ResponseDiffValidator {

  public ResponseHeadersDiffValidator(List<HeaderDiffValidator> valueValidators) {
    super(valueValidators);
  }

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    ApiResponse leftOasObject, OasObjectPropertyLocation rightLocation, ApiResponse rightOasObject) {

    enterResponse(context);

    List<OasDiffViolation> violations = super
      .validate(context, leftLocation, leftOasObject, rightLocation, rightOasObject);

    leaveResponse(context);
    return violations;
  }

  @Override
  protected Map<String, Header> getMapProperty(ApiResponse components) {
    return components.getHeaders();
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
