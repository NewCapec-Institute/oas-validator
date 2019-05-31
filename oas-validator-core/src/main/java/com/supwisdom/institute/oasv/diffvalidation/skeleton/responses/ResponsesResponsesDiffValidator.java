package com.supwisdom.institute.oasv.diffvalidation.skeleton.responses;

import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.responses.ApiResponse;
import io.swagger.v3.oas.models.responses.ApiResponses;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasObjectDiffValidatorUtils.doDiffValidateProperty;

public class ResponsesResponsesDiffValidator
  extends OasObjectDiffValidatorTemplate<ApiResponses>
  implements ResponsesDiffValidator {

  private final List<ResponseDiffValidator> responseValidators;

  public ResponsesResponsesDiffValidator(List<ResponseDiffValidator> responseValidators) {
    this.responseValidators = responseValidators;
  }

  @Override
  public List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, ApiResponses leftOasObject,
    OasObjectPropertyLocation rightLocation, ApiResponses rightOasObject) {

    List<OasDiffViolation> violations = new ArrayList<>();

    for (Map.Entry<String, ApiResponse> entry : leftOasObject.entrySet()) {
      String leftStatus = entry.getKey();
      ApiResponse leftResponse = entry.getValue();
      OasObjectPropertyLocation leftResponseLoc = leftLocation.property(leftStatus, OasObjectType.RESPONSE);

      ApiResponse rightResponse = rightOasObject.get(leftStatus);
      if (rightResponse == null) {
        violations.addAll(
          doDiffValidateProperty(
            context,
            leftResponseLoc,
            leftResponse,
            null,
            null,
            responseValidators
          )
        );
      } else {
        OasObjectPropertyLocation rightResponseLoc = rightLocation.property(leftStatus, OasObjectType.RESPONSE);
        violations.addAll(
          doDiffValidateProperty(
            context,
            leftResponseLoc,
            leftResponse,
            rightResponseLoc,
            rightResponse,
            responseValidators
          )
        );
      }
    }

    for (Map.Entry<String, ApiResponse> entry : rightOasObject.entrySet()) {
      String rightStatus = entry.getKey();
      if (leftOasObject.containsKey(rightStatus)) {
        continue;
      }
      ApiResponse rightResponse = entry.getValue();
      OasObjectPropertyLocation rightResponseLoc = rightLocation.property(rightStatus, OasObjectType.RESPONSE);
      violations.addAll(
        doDiffValidateProperty(
          context,
          null,
          null,
          rightResponseLoc,
          rightResponse,
          responseValidators
        )
      );
    }
    return violations;
  }

}
