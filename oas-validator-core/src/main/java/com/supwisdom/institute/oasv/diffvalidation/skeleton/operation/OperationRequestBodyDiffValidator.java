package com.supwisdom.institute.oasv.diffvalidation.skeleton.operation;

import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OperationDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.RequestBodyDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.REQUEST_BODY;

public class OperationRequestBodyDiffValidator
  extends ObjectPropertyDiffValidator<Operation, RequestBody>
  implements OperationDiffValidator {

  public OperationRequestBodyDiffValidator(
    List<RequestBodyDiffValidator> requestBodyDiffValidators) {
    super(requestBodyDiffValidators);
  }

  @Override
  protected RequestBody getPropertyObject(Operation oasObject) {
    return oasObject.getRequestBody();
  }

  @Override
  protected String getPropertyName() {
    return "requestBody";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return REQUEST_BODY;
  }

}
