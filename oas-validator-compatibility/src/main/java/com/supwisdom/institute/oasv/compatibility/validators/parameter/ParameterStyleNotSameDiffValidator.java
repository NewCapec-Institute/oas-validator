package com.supwisdom.institute.oasv.compatibility.validators.parameter;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.diffvalidation.util.ParameterUtils;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class ParameterStyleNotSameDiffValidator
  extends OasObjectDiffValidatorTemplate<Parameter>
  implements ParameterDiffValidator {

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Parameter leftOasObject, OasObjectPropertyLocation rightLocation,
    Parameter rightOasObject) {

    if (Objects.equals(leftOasObject.getStyle(), rightOasObject.getStyle())) {
      return emptyList();
    }

    String message = new StringBuilder()
      .append(ParameterUtils.getKeyString(rightOasObject))
      .append(':')
      .append(DiffViolationMessages.NEW_NOT_EQ_OLD)
      .toString();

    return singletonList(new OasDiffViolation(
      leftLocation.property("style"),
      rightLocation.property("style"),
      message
    ));

  }

}
