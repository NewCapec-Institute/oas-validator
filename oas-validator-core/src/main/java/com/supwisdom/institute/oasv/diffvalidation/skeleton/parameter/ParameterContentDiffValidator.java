package com.supwisdom.institute.oasv.diffvalidation.skeleton.parameter;

import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.MEDIA_TYPE;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.*;

public class ParameterContentDiffValidator
  extends MapPropertyDiffValidator<Parameter, MediaType>
  implements ParameterDiffValidator {

  public ParameterContentDiffValidator(List<MediaTypeDiffValidator> mediaTypeValidators) {
    super(mediaTypeValidators);
  }

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    Parameter leftOasObject, OasObjectPropertyLocation rightLocation, Parameter rightOasObject) {

    enterParameter(context);

    List<OasDiffViolation> violations = super
      .validate(context, leftLocation, leftOasObject, rightLocation, rightOasObject);

    leaveParameter(context);
    return violations;
  }

  @Override
  protected Map<String, MediaType> getMapProperty(Parameter oasObject) {
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
