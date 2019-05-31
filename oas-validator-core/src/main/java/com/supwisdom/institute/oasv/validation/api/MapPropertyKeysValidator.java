package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils.doValidateMapPropertyKeys;
import static java.util.Collections.emptyList;

public abstract class MapPropertyKeysValidator<T> implements OasObjectValidator<T> {

  private final Predicate<String> keyPredicate;

  private final Function<String, String> errorFunction;

  public MapPropertyKeysValidator(Predicate<String> keyPredicate,
    Function<String, String> errorFunction) {
    this.keyPredicate = keyPredicate;
    this.errorFunction = errorFunction;
  }

  @Override
  final public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    T oasObject) {

    if (StringUtils.isNotBlank(get$ref(oasObject))) {
      return emptyList();
    }

    return doValidateMapPropertyKeys(
      location,
      getMapPropertyName(),
      getMapProperty(oasObject),
      keyPredicate,
      errorFunction
    );

  }

  protected abstract String get$ref(T oasObject);

  protected abstract Map<String, ?> getMapProperty(T oasObject);

  protected abstract String getMapPropertyName();

}
