package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;

import java.util.List;
import java.util.function.Function;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasObjectDiffValidatorUtils.doDiffValidateListProperty;

public abstract class ListPropertyDiffValidator<T, P>
  extends OasObjectDiffValidatorTemplate<T> {

  private final List<? extends OasObjectDiffValidator<P>> elementDiffValidators;

  private final Function<P, ?> elementKeyMapper;

  protected ListPropertyDiffValidator(
    List<? extends OasObjectDiffValidator<P>> elementDiffValidators,
    Function<P, Object> elementKeyMapper) {
    this.elementDiffValidators = elementDiffValidators;
    this.elementKeyMapper = elementKeyMapper;
  }

  @Override
  public List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, T leftOasObject,
    OasObjectPropertyLocation rightLocation, T rightOasObject) {

    return doDiffValidateListProperty(
      context,
      getListPropertyName(),
      leftLocation,
      getListProperty(leftOasObject),
      rightLocation,
      getListProperty(rightOasObject),
      getElementType(),
      elementKeyMapper,
      elementDiffValidators
    );

  }

  protected abstract List<P> getListProperty(T oasObject);

  protected abstract String getListPropertyName();

  protected abstract OasObjectType getElementType();
}
