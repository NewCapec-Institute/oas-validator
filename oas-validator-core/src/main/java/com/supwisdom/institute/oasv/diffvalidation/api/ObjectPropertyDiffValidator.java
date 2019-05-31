package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasObjectDiffValidatorUtils.doDiffValidateProperty;

/**
 * OAS Object对象的对象类型的属性差异校验器
 *
 * @param <T> <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#table-of-contents">OpenAPI Specification</a>所定义的对象
 * @param <P> 属性的类型
 */
public abstract class ObjectPropertyDiffValidator<T, P>
  extends OasObjectDiffValidatorTemplate<T> {

  private final List<? extends OasObjectDiffValidator<P>> diffValidators;

  protected ObjectPropertyDiffValidator(List<? extends OasObjectDiffValidator<P>> diffValidators) {
    this.diffValidators = diffValidators;
  }

  @Override
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, T leftOasObject, OasObjectPropertyLocation rightLocation,
    T rightOasObject) {

    P leftProperty = getPropertyObject(leftOasObject);
    P rightProperty = getPropertyObject(rightOasObject);

    OasObjectPropertyLocation leftPropertyLoc =
      leftProperty == null ? null : leftLocation.property(getPropertyName(), getPropertyType());
    OasObjectPropertyLocation rightPropertyLoc =
      rightProperty == null ? null : rightLocation.property(getPropertyName(), getPropertyType());

    return doDiffValidateProperty(context, leftPropertyLoc, leftProperty, rightPropertyLoc, rightProperty,
      diffValidators);

  }

  /**
   * @param oasObject 不用担心会是null
   * @return
   */
  protected abstract P getPropertyObject(T oasObject);

  protected abstract String getPropertyName();

  protected abstract OasObjectType getPropertyType();

}
