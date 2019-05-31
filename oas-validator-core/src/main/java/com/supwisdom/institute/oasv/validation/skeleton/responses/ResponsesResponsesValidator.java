package com.supwisdom.institute.oasv.validation.skeleton.responses;

import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.ResponseValidator;
import com.supwisdom.institute.oasv.validation.api.ResponsesValidator;
import com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#responsesObject">Responses Object</a>
 * .default / .{Http Status Code} 属性校验器
 */
public class ResponsesResponsesValidator implements ResponsesValidator {

  private final List<ResponseValidator> responseValidators;

  public ResponsesResponsesValidator(List<ResponseValidator> responseValidators) {
    this.responseValidators = responseValidators;
  }

  @Override
  public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    ApiResponses oasObject) {

    List<OasViolation> violations = new ArrayList<>();

    for (Map.Entry<String, ApiResponse> entry : oasObject.entrySet()) {
      String statusCode = entry.getKey();
      ApiResponse response = entry.getValue();
      OasObjectPropertyLocation responseLoc = location.property(statusCode, OasObjectType.RESPONSE);
      violations.addAll(OasObjectValidatorUtils.doValidateProperty(context, responseLoc, response, responseValidators));
    }

    return violations;

  }
}
