package com.supwisdom.institute.oasv.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public abstract class StringCaseUtils {

  private static final Pattern LOWER_CAMEL_CASE = Pattern.compile("^[a-z]+((\\d)|([A-Z0-9][a-z0-9]+))*([A-Z])?$");

  private static final Pattern UPPER_CAMEL_CASE = Pattern.compile("^[A-Z]([a-z0-9]+[A-Z]?)*$");

  private static final Pattern UPPER_HYPHEN_CASE = Pattern.compile("^([A-Z][a-z0-9]*-)*([A-Z][a-z0-9]*)$");

  private StringCaseUtils() {
    // singleton
  }

  public static boolean isLowerCamelCase(String string) {
    if (StringUtils.isBlank(string)) {
      return false;
    }
    return LOWER_CAMEL_CASE.matcher(string).matches();
  }

  public static boolean isUpperCamelCase(String string) {
    if (StringUtils.isBlank(string)) {
      return false;
    }
    return UPPER_CAMEL_CASE.matcher(string).matches();
  }

  public static boolean isUpperHyphenCase(String string) {
    if (StringUtils.isBlank(string)) {
      return false;
    }
    return UPPER_HYPHEN_CASE.matcher(string).matches();
  }

}
