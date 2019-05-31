package com.supwisdom.institute.oasv.compliance.validator.openapi;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.*;
import io.swagger.v3.oas.models.OpenAPI;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .openapi属性校验器
 * <ul>
 * <li>必须为3.0.x且>=3.0.2</li>
 * </ul>
 */
public class OpenApiVersionValidator implements OpenApiValidator {

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, OpenAPI openAPI) {

    if (openAPI.getOpenapi() == null) {
      return singletonList(new OasViolation(location.property("openapi"), ViolationMessages.REQUIRED));
    }

    String[] semver = openAPI.getOpenapi().split("\\.");
    boolean ok = semver[0].equals("3") && semver[1].equals("0") && Integer.parseInt(semver[2]) >= 2;
    if (ok) {
      return emptyList();
    }
    return singletonList(new OasViolation(location.property("openapi"), "必须>=3.0.2"));
  }

}
