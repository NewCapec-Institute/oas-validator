package com.supwisdom.institute.oasv.diffvalidation.skeleton.response;

import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.MEDIA_TYPE;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.*;

public class ResponseContentDiffValidator
  extends MapPropertyDiffValidator<ApiResponse, MediaType>
  implements ResponseDiffValidator {

  public ResponseContentDiffValidator(List<MediaTypeDiffValidator> mediaTypeValidators) {
    super(mediaTypeValidators);
  }

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    ApiResponse leftOasObject, OasObjectPropertyLocation rightLocation, ApiResponse rightOasObject) {

    enterResponse(context);

    List<OasDiffViolation> violations = super
      .validate(context, leftLocation, leftOasObject, rightLocation, rightOasObject);

    leaveResponse(context);
    return violations;
  }

  @Override
  protected Map<String, MediaType> getMapProperty(ApiResponse oasObject) {
    return oasObject.getContent();
  }

  @Override
  protected String getMapPropertyName() {
    return "content";
  }

  @Override
  protected OasObjectType getValueType() {
    return MEDIA_TYPE;
  }

}
