package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

public interface SchemaDelValidator {

  /**
   * 左侧有，右侧没有，即被删除的情况。
   *
   * @param context
   * @param leftLocation
   * @param leftOasObject 被删除的Object
   * @return
   */
  List<OasDiffViolation> validate(
    OasDiffValidationContext context, OasObjectPropertyLocation leftLocation, Schema leftOasObject);

}
