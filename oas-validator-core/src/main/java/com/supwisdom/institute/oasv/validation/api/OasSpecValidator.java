package com.supwisdom.institute.oasv.validation.api;

import io.swagger.v3.oas.models.OpenAPI;

import java.util.List;

/**
 * OAS Spec校验器
 */
public interface OasSpecValidator {

  List<OasViolation> validate(OasValidationContext context, OpenAPI openAPI);

}
