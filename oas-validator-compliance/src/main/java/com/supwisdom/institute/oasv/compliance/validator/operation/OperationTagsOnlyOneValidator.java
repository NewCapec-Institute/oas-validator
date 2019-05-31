package com.supwisdom.institute.oasv.compliance.validator.operation;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.OperationValidator;
import io.swagger.v3.oas.models.Operation;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#operationObject">Operation Object</a>
 * .tags属性校验器
 * <ul>
 * <li>必须写一个</li>
 * <li>必须在OpenAPI Object的tags属性里有对应property: description，rule：必填</li>
 * </ul>
 */
public class OperationTagsOnlyOneValidator implements OperationValidator {

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    Operation oasObject) {

    List<String> tags = oasObject.getTags();
    if (CollectionUtils.size(tags) != 1) {
      return singletonList(
        new OasViolation(location.property("tags"), "必须提供且只提供一个tag"));
    }
    return emptyList();
  }

}