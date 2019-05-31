package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasObjectDiffValidatorUtils.assertNullGood;
import static java.util.Collections.emptyList;

public class OasObjectDiffValidatorTemplate<T> implements OasObjectDiffValidator<T> {

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, T leftOasObject,
    OasObjectPropertyLocation rightLocation, T rightOasObject) {

    assertNullGood(leftLocation, leftOasObject, rightLocation, rightOasObject);
    if (leftOasObject == null && rightOasObject != null) {
      return validateAdd(context, rightLocation, rightOasObject);
    }
    if (leftOasObject != null && rightOasObject == null) {
      return validateDel(context, leftLocation, leftOasObject);
    }
    return validateCompare(context, leftLocation, leftOasObject, rightLocation, rightOasObject);
  }

  /**
   * 处理左边没有，右边有，即新增的情况。
   *
   * @param context
   * @param rightLocation
   * @param rightOasObject
   * @return
   */
  protected List<OasDiffViolation> validateAdd(OasDiffValidationContext context, OasObjectPropertyLocation rightLocation,
    T rightOasObject) {
    return emptyList();
  }

  /**
   * 处理左边有，右边没有，即删除的情况。
   *
   * @param context
   * @param leftLocation
   * @param leftOasObject
   * @return
   */
  protected List<OasDiffViolation> validateDel(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    T leftOasObject) {
    return emptyList();
  }

  /**
   * 左右两边都有的情况。要注意，左右两边Object可能是equals==true的。
   *
   * @param context
   * @param leftLocation
   * @param leftOasObject
   * @param rightLocation
   * @param rightOasObject
   * @return
   */
  protected List<OasDiffViolation> validateCompare(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, T leftOasObject,
    OasObjectPropertyLocation rightLocation, T rightOasObject) {
    return emptyList();
  }

}
