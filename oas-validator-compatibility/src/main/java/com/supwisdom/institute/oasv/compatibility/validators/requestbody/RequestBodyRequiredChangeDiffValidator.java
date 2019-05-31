package com.supwisdom.institute.oasv.compatibility.validators.requestbody;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasObjectDiffValidatorTemplate;
import com.supwisdom.institute.oasv.diffvalidation.api.RequestBodyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.util.ChangeRangeCheckUtils;
import io.swagger.v3.oas.models.parameters.RequestBody;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 仅允许true->false的修改
 */
public class RequestBodyRequiredChangeDiffValidator
  extends OasObjectDiffValidatorTemplate<RequestBody>
  implements RequestBodyDiffValidator {

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, RequestBody leftOasObject, OasObjectPropertyLocation rightLocation,
    RequestBody rightOasObject) {

    if (ChangeRangeCheckUtils.isNotViolated(
      ObjectUtils.defaultIfNull(leftOasObject.getRequired(), Boolean.FALSE),
      ObjectUtils.defaultIfNull(rightOasObject.getRequired(), Boolean.FALSE),
      singletonList(new Object[] { true, false }))) {
      return emptyList();
    }

    return singletonList(new OasDiffViolation(
      leftLocation.property("required"),
      rightLocation.property("required"),
      "仅允许true->false的修改"
    ));

  }

}
