package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils.doValidateProperty;
import static java.util.Collections.emptyList;

/**
 * OAS Object对象的对象类型的属性校验器
 *
 * @param <T> <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#table-of-contents">OpenAPI Specification</a>所定义的对象
 * @param <P> 属性的类型
 */
public abstract class ObjectPropertyValidator<T, P> implements OasObjectValidator<T> {

  private final List<? extends OasObjectValidator<P>> oasObjectValidators;

  protected ObjectPropertyValidator(List<? extends OasObjectValidator<P>> oasObjectValidators) {
    this.oasObjectValidators = oasObjectValidators;
  }

  @Override
  final public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    T oasObject) {
    if (StringUtils.isNotBlank(get$ref(oasObject))) {
      return emptyList();
    }

    P propertyObject = getPropertyObject(oasObject);
    if (propertyObject == null) {
      return emptyList();
    }
    OasObjectPropertyLocation propertyLoc = location.property(getPropertyName(), getPropertyType());
    return doValidateProperty(context, propertyLoc, propertyObject, oasObjectValidators);

  }

  protected abstract String get$ref(T oasObject);

  protected abstract P getPropertyObject(T oasObject);

  protected abstract String getPropertyName();

  protected abstract OasObjectType getPropertyType();

}
