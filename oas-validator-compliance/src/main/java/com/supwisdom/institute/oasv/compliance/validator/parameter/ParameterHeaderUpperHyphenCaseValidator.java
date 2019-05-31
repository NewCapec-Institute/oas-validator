package com.supwisdom.institute.oasv.compliance.validator.parameter;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.util.StringCaseUtils;
import com.supwisdom.institute.oasv.validation.api.*;
import io.swagger.v3.oas.models.parameters.Parameter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#parameterObject">Parameter Object</a>
 * .name 属性校验器
 * <ul>
 * <li>如果in=header，必须是upper hyphen case</li>
 * </ul>
 */
public class ParameterHeaderUpperHyphenCaseValidator implements ParameterValidator {
  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    Parameter oasObject) {

    if (StringUtils.isNotBlank(oasObject.get$ref())) {
      return emptyList();
    }

    if (!"header".equalsIgnoreCase(oasObject.getIn())) {
      return emptyList();
    }

    if (!StringCaseUtils.isUpperHyphenCase(oasObject.getName())) {
      return singletonList(new OasViolation(location.property("name"), ViolationMessages.UPPER_HYPHEN_CASE));
    }

    return emptyList();

  }
}
