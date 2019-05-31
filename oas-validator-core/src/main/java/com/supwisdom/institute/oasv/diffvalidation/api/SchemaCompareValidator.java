package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.diffvalidation.skeleton.schema.SchemaDiffValidatorEngine;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

public interface SchemaCompareValidator {

  /**
   * 左右两侧都有的情况，比较左右两侧对象。
   * <p>
   * 此方法不需要比较allOf、anyOf、oneOf、items、properties
   * </p>
   * 这些field的递归工作由{@link SchemaDiffValidatorEngine}完成。
   *
   * @param context
   * @param leftLocation
   * @param leftOasObject
   * @param rightLocation
   * @param rightOasObject
   * @return
   */
  List<OasDiffViolation> validate(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, Schema leftOasObject,
    OasObjectPropertyLocation rightLocation, Schema rightOasObject);

}
