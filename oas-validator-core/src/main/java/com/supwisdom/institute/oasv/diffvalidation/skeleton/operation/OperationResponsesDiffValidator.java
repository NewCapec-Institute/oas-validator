package com.supwisdom.institute.oasv.diffvalidation.skeleton.operation;

import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OperationDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ResponsesDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.RESPONSES;

public class OperationResponsesDiffValidator
  extends ObjectPropertyDiffValidator<Operation, ApiResponses>
  implements OperationDiffValidator {

  public OperationResponsesDiffValidator(List<ResponsesDiffValidator> responsesDiffValidators) {
    super(responsesDiffValidators);
  }

  @Override
  protected ApiResponses getPropertyObject(Operation oasObject) {
    return oasObject.getResponses();
  }

  @Override
  protected String getPropertyName() {
    return "responses";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return RESPONSES;
  }

}
