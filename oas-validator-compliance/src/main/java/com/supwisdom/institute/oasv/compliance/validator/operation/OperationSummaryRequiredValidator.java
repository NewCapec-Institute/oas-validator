package com.supwisdom.institute.oasv.compliance.validator.operation;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.OperationValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyRequiredValidator;
import io.swagger.v3.oas.models.Operation;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * .summary属性校验器
 * <ul>
 * <li>必填</li>
 * </ul>
 */
public class OperationSummaryRequiredValidator
  extends ObjectPropertyRequiredValidator<Operation, String>
  implements OperationValidator {

  @Override
  protected String get$ref(Operation oasObject) {
    return null;
  }

  @Override
  protected String getPropertyObject(Operation oasObject) {
    return oasObject.getSummary();
  }

  @Override
  protected String getPropertyName() {
    return "summary";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return null;
  }

}
