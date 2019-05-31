package com.supwisdom.institute.oasv.compatibility.validators.operation;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.Operation;

import java.util.List;

import static java.util.Collections.singletonList;

public class OperationDeleteNotAllowedDiffValidator
  extends OasObjectDiffValidatorTemplate<Operation>
  implements OperationDiffValidator {

  @Override
  protected List<OasDiffViolation> validateDel(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    Operation leftOasObject) {

    return singletonList(OasDiffViolation.onlyLeft(leftLocation, DiffViolationMessages.OP_DEL_FORBIDDEN));
  }
}
