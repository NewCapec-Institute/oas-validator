package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils.doValidateListProperty;
import static java.util.Collections.emptyList;

public abstract class ListPropertyValidator<T, P> implements OasObjectValidator<T> {

  private final List<? extends OasObjectValidator<P>> valueValidators;

  protected ListPropertyValidator(List<? extends OasObjectValidator<P>> valueValidators) {
    this.valueValidators = valueValidators;
  }

  @Override
  final public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    T oasObject) {

    if (StringUtils.isNotBlank(get$ref(oasObject))) {
      return emptyList();
    }

    return doValidateListProperty(
      context, location,
      getListPropertyName(),
      getListProperty(oasObject),
      getElementType(),
      valueValidators
    );

  }

  protected abstract String get$ref(T oasObject);

  protected abstract List<P> getListProperty(T oasObject);

  protected abstract String getListPropertyName();

  protected abstract OasObjectType getElementType();
}
