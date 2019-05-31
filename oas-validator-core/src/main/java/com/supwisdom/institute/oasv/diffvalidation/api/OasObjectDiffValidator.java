package com.supwisdom.institute.oasv.diffvalidation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;

import java.util.List;

/**
 * OAS Object差异校验器接口
 *
 * @param <T> <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#table-of-contents">OpenAPI Specification</a>所定义的对象
 */
public interface OasObjectDiffValidator<T> {

  /**
   * leftOasObject 和 rightOasObject 不可同时为null
   *
   * @param context        差异校验上下文
   * @param leftLocation   左侧OAS Object位置（可能为空）
   * @param leftOasObject  左侧OAS Object（可能为空）
   * @param rightLocation  右侧OAS Object位置（可能为空）
   * @param rightOasObject 右侧OAS Object（可能为空）
   * @return 差异校验违例
   */
  List<OasDiffViolation> validate(OasDiffValidationContext context,
    OasObjectPropertyLocation leftLocation, T leftOasObject,
    OasObjectPropertyLocation rightLocation, T rightOasObject);

}
