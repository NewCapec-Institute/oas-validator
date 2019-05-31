package com.supwisdom.institute.oasv.compatibility.validators.operation;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.Operation;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class OperationIdNotSameDiffValidator
  extends OasObjectDiffValidatorTemplate<Operation>
  implements OperationDiffValidator {

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Operation leftOasObject, OasObjectPropertyLocation rightLocation,
    Operation rightOasObject) {
    if (leftOasObject.getOperationId().equalsIgnoreCase(rightOasObject.getOperationId())) {
      return emptyList();
    }
    return singletonList(new OasDiffViolation(
      leftLocation.property("operationId"),
      rightLocation.property("operationId"),
      DiffViolationMessages.NEW_NOT_EQ_OLD));

  }
}
