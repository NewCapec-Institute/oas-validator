package com.supwisdom.institute.oasv.util;

import java.util.List;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-specification">OAS Spec</a>的语法检查器。
 * 只检查属性名是否正确
 */
public interface OasSpecSyntaxChecker {

  /**
   * 检查语法错误
   *
   * @param oasSpecContent
   * @return 语法错误消息，如果是empty，则代表没有语法错误
   */
  List<String> check(String oasSpecContent);

}
