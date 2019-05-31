package com.supwisdom.institute.oasv.compatibility.validators.parameter;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasObjectDiffValidatorTemplate;
import com.supwisdom.institute.oasv.diffvalidation.api.ParameterDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.util.ParameterUtils;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public class ParameterAddDiffValidator
  extends OasObjectDiffValidatorTemplate<Parameter>
  implements ParameterDiffValidator {

  @Override
  protected List<OasDiffViolation> validateAdd(OasDiffValidationContext context,
    OasObjectPropertyLocation rightLocation, Parameter rightOasObject) {

    if (Boolean.FALSE.equals(rightOasObject.getRequired())) {
      return emptyList();
    }

    String message = new StringBuilder()
      .append(ParameterUtils.getKeyString(rightOasObject))
      .append(':')
      .append("仅允许新增required=false的parameter")
      .toString()
      ;

    return singletonList(OasDiffViolation.onlyRight(rightLocation.property("required"), message));

  }
}
