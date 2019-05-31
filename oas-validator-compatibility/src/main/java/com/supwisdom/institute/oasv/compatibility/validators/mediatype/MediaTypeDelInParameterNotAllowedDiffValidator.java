package com.supwisdom.institute.oasv.compatibility.validators.mediatype;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.media.MediaType;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 不允许在Parameter.content下删除MediaType
 */
public class MediaTypeDelInParameterNotAllowedDiffValidator
  extends OasObjectDiffValidatorTemplate<MediaType>
  implements MediaTypeDiffValidator {

  @Override
  protected List<OasDiffViolation> validateDel(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    MediaType leftOasObject) {
    if (!isInParameter(context)) {
      return emptyList();
    }
    return singletonList(OasDiffViolation.onlyLeft(leftLocation, DiffViolationMessages.OP_DEL_FORBIDDEN));
  }

}
