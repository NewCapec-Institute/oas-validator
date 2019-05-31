package com.supwisdom.institute.oasv.compliance.validator.parameter;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ParameterValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyRequiredValidator;
import io.swagger.v3.oas.models.parameters.Parameter;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#parameterObject">Parameter Object</a>
 * .description 属性校验器
 * <ul>
 * <li>必须提供</li>
 * </ul>
 */
public class ParameterDescriptionRequiredValidator
  extends ObjectPropertyRequiredValidator<Parameter, String>
  implements ParameterValidator {

  @Override
  protected String get$ref(Parameter oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected String getPropertyObject(Parameter oasObject) {
    return oasObject.getDescription();
  }

  @Override
  protected String getPropertyName() {
    return "description";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return null;
  }

}
