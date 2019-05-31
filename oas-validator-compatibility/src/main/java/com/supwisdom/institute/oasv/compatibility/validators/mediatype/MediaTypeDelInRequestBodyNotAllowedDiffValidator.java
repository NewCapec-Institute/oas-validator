package com.supwisdom.institute.oasv.compatibility.validators.mediatype;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.media.MediaType;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 不允许在RequestBody.content下删除MediaType
 */
public class MediaTypeDelInRequestBodyNotAllowedDiffValidator
  extends OasObjectDiffValidatorTemplate<MediaType>
  implements MediaTypeDiffValidator {

  @Override
  protected List<OasDiffViolation> validateDel(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    MediaType leftOasObject) {
    if (!isInRequestBody(context)) {
      return emptyList();
    }
    return singletonList(OasDiffViolation.onlyLeft(leftLocation, DiffViolationMessages.OP_DEL_FORBIDDEN));
  }

}
