package com.supwisdom.institute.oasv.compliance.validator.header;

import com.supwisdom.institute.oasv.validation.api.HeaderValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyRequiredValidator;
import io.swagger.v3.oas.models.headers.Header;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#headerObject">Header Object</a>
 * .description属性校验器
 * <ul>
 * <li>必须填写</li>
 * </ul>
 */
public class HeaderDescriptionRequiredValidator
  extends ObjectPropertyRequiredValidator<Header, String>
  implements HeaderValidator {

  @Override
  protected String get$ref(Header oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected String getPropertyObject(Header oasObject) {
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
