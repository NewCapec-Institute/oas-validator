package com.supwisdom.institute.oasv.compatibility.validators.encoding;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.media.Encoding;

import java.util.List;

import static java.util.Collections.singletonList;

public class EncodingAddNotAllowedDiffValidator
  extends OasObjectDiffValidatorTemplate<Encoding>
  implements EncodingDiffValidator {

  @Override
  protected List<OasDiffViolation> validateAdd(OasDiffValidationContext context,
    OasObjectPropertyLocation rightLocation, Encoding rightOasObject) {
    return singletonList(OasDiffViolation.onlyRight(rightLocation, DiffViolationMessages.OP_ADD_FORBIDDEN));
  }

}
