package com.supwisdom.institute.oasv.compliance.validator.info;

import com.supwisdom.institute.oasv.validation.api.InfoValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyRequiredValidator;
import io.swagger.v3.oas.models.info.Info;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#infoObject">Info Object</a>属性校验器
 * <ul>
 * <li>description必须填写</li>
 * <li>version必须和Api版本一致</li>
 * </ul>
 */
public class InfoDescriptionRequiredValidator
  extends ObjectPropertyRequiredValidator<Info, String>
  implements InfoValidator {

  @Override
  protected String get$ref(Info oasObject) {
    return null;
  }

  @Override
  protected String getPropertyObject(Info oasObject) {
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
