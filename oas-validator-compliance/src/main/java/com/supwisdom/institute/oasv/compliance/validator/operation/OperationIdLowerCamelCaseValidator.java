package com.supwisdom.institute.oasv.compliance.validator.operation;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.util.StringCaseUtils;
import com.supwisdom.institute.oasv.validation.api.*;
import io.swagger.v3.oas.models.Operation;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * operationId. 属性校验器lower camel case
 * </ul>
 */
public class OperationIdLowerCamelCaseValidator implements OperationValidator {

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    Operation oasObject) {

    if (!StringCaseUtils.isLowerCamelCase(oasObject.getOperationId())) {
      return singletonList(new OasViolation(location.property("operationId"), ViolationMessages.LOWER_CAMEL_CASE));
    }
    return emptyList();
  }

}
