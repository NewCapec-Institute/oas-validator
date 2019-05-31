package com.supwisdom.institute.oasv.compliance.validator.tag;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.*;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.List;

import static com.supwisdom.institute.oasv.util.StringCaseUtils.isUpperCamelCase;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#tagObject">Tag Object</a>
 * .name属性校验器
 * <ul>
 * <li>upper camel case</li>
 * </ul>
 */
public class TagNameUpperCamelCaseValidator implements TagValidator {

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, Tag tag) {

    if (!isUpperCamelCase(tag.getName())) {
      return singletonList(new OasViolation(location.property("name"), ViolationMessages.UPPER_CAMEL_CASE));
    }
    return emptyList();
  }

}
