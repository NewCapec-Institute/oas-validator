package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasObjectDiffValidatorUtils.doDiffValidateMapProperty;

public abstract class MapPropertyDiffValidator<T, P>
  extends OasObjectDiffValidatorTemplate<T> {

  private final List<? extends OasObjectDiffValidator<P>> valueDiffValidators;

  protected MapPropertyDiffValidator(List<? extends OasObjectDiffValidator<P>> valueDiffValidators) {
    this.valueDiffValidators = valueDiffValidators;
  }

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, T leftOasObject, OasObjectPropertyLocation rightLocation,
    T rightOasObject) {

    return doDiffValidateMapProperty(
      context,
      getMapPropertyName(),
      leftLocation,
      getMapProperty(leftOasObject),
      rightLocation,
      getMapProperty(rightOasObject),
      getValueType(),
      valueDiffValidators
    );

  }

  protected abstract Map<String, P> getMapProperty(T oasObject);

  protected abstract String getMapPropertyName();

  protected abstract OasObjectType getValueType();
}
