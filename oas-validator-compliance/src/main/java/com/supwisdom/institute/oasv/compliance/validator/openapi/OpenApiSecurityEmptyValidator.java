package com.supwisdom.institute.oasv.compliance.validator.openapi;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import io.swagger.v3.oas.models.OpenAPI;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SECURITY_REQUIREMENT;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .security属性校验器
 * <ul>
 * <li>不允许提供</li>
 * </ul>
 */
public class OpenApiSecurityEmptyValidator implements OpenApiValidator {

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    OpenAPI openAPI) {

    if (CollectionUtils.isEmpty(openAPI.getSecurity())) {
      return emptyList();

    }

    return singletonList(
      new OasViolation(location.property("security", SECURITY_REQUIREMENT), ViolationMessages.MUST_BE_EMPTY));

  }

}
