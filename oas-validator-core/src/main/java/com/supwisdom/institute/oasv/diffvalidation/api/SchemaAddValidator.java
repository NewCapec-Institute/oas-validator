package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

public interface SchemaAddValidator {

  /**
   * 左侧没有，右侧有，即新增的情况。
   *
   * @param context
   * @param rightLocation
   * @param rightOasObject 新增的Object
   * @return
   */
  List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation rightLocation,
    Schema rightOasObject);

}
