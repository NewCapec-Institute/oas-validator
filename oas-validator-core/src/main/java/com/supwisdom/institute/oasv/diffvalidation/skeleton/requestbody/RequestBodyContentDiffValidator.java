package com.supwisdom.institute.oasv.diffvalidation.skeleton.requestbody;

import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.MEDIA_TYPE;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.*;

public class RequestBodyContentDiffValidator
  extends MapPropertyDiffValidator<RequestBody, MediaType>
  implements RequestBodyDiffValidator {

  public RequestBodyContentDiffValidator(List<MediaTypeDiffValidator> mediaTypeValidators) {
    super(mediaTypeValidators);
  }

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    RequestBody leftOasObject, OasObjectPropertyLocation rightLocation, RequestBody rightOasObject) {

    enterRequestBody(context);

    List<OasDiffViolation> violations = super
      .validate(context, leftLocation, leftOasObject, rightLocation, rightOasObject);

    leaveRequestBody(context);
    return violations;
  }

  @Override
  protected Map<String, MediaType> getMapProperty(RequestBody oasObject) {
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
