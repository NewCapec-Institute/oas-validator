package com.supwisdom.institute.oasv.compatibility.validators.encoding;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.EncodingDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasObjectDiffValidatorTemplate;
import com.supwisdom.institute.oasv.diffvalidation.util.ChangeRangeCheckUtils;
import io.swagger.v3.oas.models.media.Encoding;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.apache.commons.lang3.ObjectUtils.defaultIfNull;

public class EncodingAllowedReservedChangeDiffValidator
  extends OasObjectDiffValidatorTemplate<Encoding>
  implements EncodingDiffValidator {

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Encoding leftOasObject, OasObjectPropertyLocation rightLocation,
    Encoding rightOasObject) {

    if (ChangeRangeCheckUtils.isNotViolated(
      defaultIfNull(leftOasObject.getAllowReserved(), Boolean.FALSE),
      defaultIfNull(rightOasObject.getAllowReserved(), Boolean.FALSE),
      singletonList(new Object[] { false, true }))) {
      return emptyList();
    }

    return singletonList(new OasDiffViolation(
      leftLocation.property("allowReserved"),
      rightLocation.property("allowReserved"),
      "仅允许false->true的修改"
    ));

  }

}
