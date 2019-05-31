package com.supwisdom.institute.oasv.compatibility.validators.header;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.headers.Header;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInResponse;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 不允许在responses.'response'.headers.headers 下删除Header Object
 */
public class HeaderDelInResponseNotAllowedDiffValidator extends OasObjectDiffValidatorTemplate<Header>
  implements HeaderDiffValidator {

  @Override
  protected List<OasDiffViolation> validateDel(OasDiffValidationContext context,
    OasObjectPropertyLocation rightLocation, Header rightOasObject) {
    if (!isInResponse(context)) {
      return emptyList();
    }
    return singletonList(OasDiffViolation.onlyLeft(rightLocation, DiffViolationMessages.OP_DEL_FORBIDDEN));
  }

}
