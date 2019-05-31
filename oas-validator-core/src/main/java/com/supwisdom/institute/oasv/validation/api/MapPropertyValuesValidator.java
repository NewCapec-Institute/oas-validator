package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils.doValidateMapPropertyValues;
import static java.util.Collections.emptyList;

public abstract class MapPropertyValuesValidator<T, P> implements OasObjectValidator<T> {

  private final List<? extends OasObjectValidator<P>> valueValidators;

  protected MapPropertyValuesValidator(List<? extends OasObjectValidator<P>> valueValidators) {
    this.valueValidators = valueValidators;
  }

  @Override
  public final List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    T oasObject) {

    if (StringUtils.isNotBlank(get$ref(oasObject))) {
      return emptyList();
    }

    return doValidateMapPropertyValues(
      context, location,
      getMapPropertyName(),
      getMapProperty(oasObject),
      getValueType(),
      valueValidators
    );

  }

  protected abstract String get$ref(T oasObject);

  protected abstract Map<String, P> getMapProperty(T oasObject);

  protected abstract String getMapPropertyName();

  protected abstract OasObjectType getValueType();
}
