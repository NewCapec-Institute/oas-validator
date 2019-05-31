package com.supwisdom.institute.oasv.compatibility.validators.parameter;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasObjectDiffValidatorTemplate;
import com.supwisdom.institute.oasv.diffvalidation.api.ParameterDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.util.ChangeRangeCheckUtils;
import com.supwisdom.institute.oasv.diffvalidation.util.ParameterUtils;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

/**
 * 仅允许false->true的修改
 */
public class ParameterAllowReservedChangeDiffValidator
  extends OasObjectDiffValidatorTemplate<Parameter>
  implements ParameterDiffValidator {

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Parameter leftOasObject, OasObjectPropertyLocation rightLocation,
    Parameter rightOasObject) {

    if (ChangeRangeCheckUtils.isNotViolated(
      defaultIfNull(leftOasObject.getAllowReserved(), Boolean.FALSE),
      defaultIfNull(rightOasObject.getAllowReserved(), Boolean.FALSE),
      singletonList(new Object[] { false, true }))) {
      return emptyList();
    }

    String message = new StringBuilder()
      .append(ParameterUtils.getKeyString(rightOasObject))
      .append(':')
      .append("仅允许false->true的修改")
      .toString();

    return singletonList(new OasDiffViolation(
      leftLocation.property("allowReserved"),
      rightLocation.property("allowReserved"),
      message
    ));

  }

}
