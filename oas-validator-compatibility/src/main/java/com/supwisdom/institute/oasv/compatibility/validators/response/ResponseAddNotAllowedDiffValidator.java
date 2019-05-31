package com.supwisdom.institute.oasv.compatibility.validators.response;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation.onlyRight;
import static java.util.Collections.singletonList;

/**
 * 不允许在responses.'http status code'.下新增 Response Object
 */
public class ResponseAddNotAllowedDiffValidator
  extends OasObjectDiffValidatorTemplate<ApiResponse>
  implements ResponseDiffValidator {

  @Override
  protected List<OasDiffViolation> validateAdd(OasDiffValidationContext context,
    OasObjectPropertyLocation rightLocation, ApiResponse rightOasObject) {
    return singletonList(onlyRight(rightLocation, DiffViolationMessages.OP_ADD_FORBIDDEN));
  }
}
