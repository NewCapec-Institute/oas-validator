package com.supwisdom.institute.oasv.compliance.validator.operation;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.OperationValidator;
import io.swagger.v3.oas.models.Operation;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SERVER;
import static com.supwisdom.institute.oasv.validation.api.ViolationMessages.MUST_BE_EMPTY;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * .servers属性校验器
 * <ul>
 * <li>不允许提供</li>
 * </ul>
 */
public class OperationServersEmptyValidator implements OperationValidator {
  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    Operation oasObject) {
    if (CollectionUtils.isEmpty(oasObject.getServers())) {
      return emptyList();
    }
    return singletonList(new OasViolation(location.property("servers", SERVER), MUST_BE_EMPTY));
  }
}
