package com.supwisdom.institute.oasv.validation.skeleton.operation;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.OperationValidator;
import com.supwisdom.institute.oasv.validation.api.RequestBodyValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.REQUEST_BODY;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * .requestBody校验器
 */
public class OperationRequestBodyValidator extends ObjectPropertyValidator<Operation, RequestBody>
  implements OperationValidator {

  public OperationRequestBodyValidator(
    List<RequestBodyValidator> requestBodyValidators) {
    super(requestBodyValidators);
  }

  @Override
  protected String get$ref(Operation oasObject) {
    return null;
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
