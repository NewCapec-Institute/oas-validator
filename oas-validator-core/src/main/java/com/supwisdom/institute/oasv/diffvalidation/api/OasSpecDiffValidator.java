package com.supwisdom.institute.oasv.diffvalidation.api;

import io.swagger.v3.oas.models.OpenAPI;

import java.util.List;

/**
 * OAS Spec差异校验器
 */
public interface OasSpecDiffValidator {

  List<OasDiffViolation> validate(OasDiffValidationContext context, OpenAPI leftOpenApi, OpenAPI rightOpenApi);

}
