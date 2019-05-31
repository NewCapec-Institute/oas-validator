package com.supwisdom.institute.oasv.compliance.validator.tag;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.TagValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyRequiredValidator;
import io.swagger.v3.oas.models.tags.Tag;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#tagObject">Tag Object</a>
 * .description 属性校验器
 * <ul>
 * <li>必填</li>
 * </ul>
 */
public class TagDescriptionRequiredValidator
  extends ObjectPropertyRequiredValidator<Tag, String>
  implements TagValidator {

  @Override
  protected String get$ref(Tag oasObject) {
    return null;
  }

  @Override
  protected String getPropertyObject(Tag oasObject) {
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
