package com.supwisdom.institute.oasv.compliance.validator.openapi;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import io.swagger.v3.oas.models.OpenAPI;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .tags(List of <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#tagObject">Tag Object</a>)大小校验器
 * <ul>
 *   <li>数量至少为一</li>
 * </ul>
 */
public class OpenApiTagNotEmptyValidator implements OpenApiValidator {

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, OpenAPI openAPI) {

    if (CollectionUtils.isEmpty(openAPI.getTags())) {
      return singletonList(new OasViolation(location.property("tags", OasObjectType.TAG), "至少提供一个"));

    }
    return emptyList();

  }

}
