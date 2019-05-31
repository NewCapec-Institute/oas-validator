package com.supwisdom.institute.oasv.compatibility.validators.header;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.headers.Header;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 不允许在requestBody.content.'mediaType'.encoding.'encoding'.headers 下添加Header Object
 */
public class HeaderAddInRequestBodyNotAllowedDiffValidator extends OasObjectDiffValidatorTemplate<Header>
  implements HeaderDiffValidator {

  @Override
  protected List<OasDiffViolation> validateAdd(OasDiffValidationContext context,
    OasObjectPropertyLocation rightLocation, Header rightOasObject) {
    if (!isInRequestBody(context)) {
      return emptyList();
    }
    return singletonList(OasDiffViolation.onlyRight(rightLocation, DiffViolationMessages.OP_ADD_FORBIDDEN));
  }

}
