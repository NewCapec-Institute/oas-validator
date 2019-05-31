package com.supwisdom.institute.oasv.compatibility.validators.mediatype;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.media.MediaType;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 不允许在Parameter.content下添加MediaType
 */
public class MediaTypeAddInParameterNotAllowedDiffValidator
  extends OasObjectDiffValidatorTemplate<MediaType>
  implements MediaTypeDiffValidator {

  @Override
  protected List<OasDiffViolation> validateAdd(OasDiffValidationContext context,
    OasObjectPropertyLocation rightLocation, MediaType rightOasObject) {
    if (!isInParameter(context)) {
      return emptyList();
    }
    return singletonList(OasDiffViolation.onlyRight(rightLocation, DiffViolationMessages.OP_ADD_FORBIDDEN));
  }

}
