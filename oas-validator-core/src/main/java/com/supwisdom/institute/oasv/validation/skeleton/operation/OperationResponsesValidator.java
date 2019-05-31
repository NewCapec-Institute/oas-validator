package com.supwisdom.institute.oasv.validation.skeleton.operation;

import com.supwisdom.institute.oasv.validation.api.OperationValidator;
import com.supwisdom.institute.oasv.validation.api.ResponsesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.RESPONSES;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * .responses校验器
 */
public class OperationResponsesValidator extends ObjectPropertyValidator<Operation, ApiResponses>
  implements OperationValidator {

  public OperationResponsesValidator(List<ResponsesValidator> responseValidators) {
    super(responseValidators);
  }

  @Override
  protected String get$ref(Operation oasObject) {
    return null;
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
