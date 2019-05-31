package com.supwisdom.institute.oasv.diffvalidation.skeleton.mediatype;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.media.Encoding;
import io.swagger.v3.oas.models.media.MediaType;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.ENCODING;

public class MediaTypeEncodingDiffValidator
  extends MapPropertyDiffValidator<MediaType, Encoding>
  implements MediaTypeDiffValidator {

  public MediaTypeEncodingDiffValidator(List<EncodingDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    MediaType leftOasObject, OasObjectPropertyLocation rightLocation, MediaType rightOasObject) {

    List<OasDiffViolation> violations = super
      .validate(context, leftLocation, leftOasObject, rightLocation, rightOasObject);

    return violations;
  }

  @Override
  protected Map<String, Encoding> getMapProperty(MediaType oasObject) {
    return oasObject.getEncoding();
  }

  @Override
  protected String getMapPropertyName() {
    return "encoding";
  }

  @Override
  protected OasObjectType getValueType() {
    return ENCODING;
  }

}
