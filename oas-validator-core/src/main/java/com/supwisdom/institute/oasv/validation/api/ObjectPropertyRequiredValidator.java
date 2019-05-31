package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * @param <T> <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#table-of-contents">OpenAPI Specification</a>所定义的对象
 * @param <P> 属性的类型
 */
public abstract class ObjectPropertyRequiredValidator<T, P> implements OasObjectValidator<T> {

  @Override
  final public List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    T oasObject) {
    if (StringUtils.isNotBlank(get$ref(oasObject))) {
      return emptyList();
    }
    P propertyObject = getPropertyObject(oasObject);
    if (propertyObject == null) {
      OasObjectPropertyLocation propertyLoc = location.property(getPropertyName(), getPropertyType());
      return singletonList(new OasViolation(propertyLoc, ViolationMessages.REQUIRED));
    }
    if (propertyObject != null && String.class.equals(propertyObject.getClass())
      && StringUtils.isBlank((CharSequence) propertyObject)) {
      OasObjectPropertyLocation propertyLoc = location.property(getPropertyName(), getPropertyType());
      return singletonList(new OasViolation(propertyLoc, ViolationMessages.REQUIRED));
    }
    return emptyList();
  }

  protected abstract String get$ref(T oasObject);

  protected abstract P getPropertyObject(T oasObject);

  protected abstract String getPropertyName();

  protected abstract OasObjectType getPropertyType();

}
