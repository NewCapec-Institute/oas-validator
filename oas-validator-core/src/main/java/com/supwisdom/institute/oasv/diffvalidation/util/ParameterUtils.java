package com.supwisdom.institute.oasv.diffvalidation.util;

import io.swagger.v3.oas.models.parameters.Parameter;

public abstract class ParameterUtils {

  public static String getKeyString(Parameter parameter) {
    return new StringBuilder()
      .append("[name=")
      .append(parameter.getName())
      .append(",in=")
      .append(parameter.getIn())
      .append("]")
      .toString();
  }
}
