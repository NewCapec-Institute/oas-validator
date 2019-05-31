package com.supwisdom.institute.oasv.validation.api;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;

import java.util.List;

/**
 *
 * @param <T> <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#table-of-contents">OpenAPI Specification</a>所定义的对象
 */
public interface OasObjectValidator<T> {

  /**
   * @param context   校验上下文
   * @param location  OpenAPI Object的位置
   * @param oasObject OpenAPI Object
   * @return 校验违例
   */
  List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location, T oasObject);

}
