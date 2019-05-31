package com.supwisdom.institute.oasv.compatibility.validators.pathitem;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.PathItem;

import java.util.List;

import static java.util.Collections.singletonList;

public class PathItemDeleteNotAllowedDiffValidator
  extends OasObjectDiffValidatorTemplate<PathItem>
  implements PathItemDiffValidator {

  @Override
  protected List<OasDiffViolation> validateDel(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    PathItem leftOasObject) {

    return singletonList(OasDiffViolation.onlyLeft(leftLocation, DiffViolationMessages.OP_DEL_FORBIDDEN));
  }

}
