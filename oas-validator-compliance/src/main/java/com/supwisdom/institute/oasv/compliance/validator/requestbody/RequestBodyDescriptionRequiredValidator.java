package com.supwisdom.institute.oasv.compliance.validator.requestbody;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.RequestBodyValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyRequiredValidator;
import io.swagger.v3.oas.models.parameters.RequestBody;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#request-body-object">Request Object</a>
 * .description 属性校验器
 * <ul>
 * <li>必须提供</li>
 * </ul>
 */
public class RequestBodyDescriptionRequiredValidator
  extends ObjectPropertyRequiredValidator<RequestBody, String>
  implements RequestBodyValidator {

  @Override
  protected String get$ref(RequestBody oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected String getPropertyObject(RequestBody oasObject) {
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
