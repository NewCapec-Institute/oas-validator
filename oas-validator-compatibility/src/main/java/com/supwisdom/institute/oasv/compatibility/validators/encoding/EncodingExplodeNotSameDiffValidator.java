package com.supwisdom.institute.oasv.compatibility.validators.encoding;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import io.swagger.v3.oas.models.media.Encoding;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class EncodingExplodeNotSameDiffValidator
  extends OasObjectDiffValidatorTemplate<Encoding>
  implements EncodingDiffValidator {

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Encoding leftOasObject, OasObjectPropertyLocation rightLocation,
    Encoding rightOasObject) {

    if (Objects.equals(leftOasObject.getExplode(), rightOasObject.getExplode())) {
      return emptyList();
    }

    return singletonList(new OasDiffViolation(
      leftLocation.property("explode"),
      rightLocation.property("explode"),
      DiffViolationMessages.NEW_NOT_EQ_OLD
    ));

  }

}
