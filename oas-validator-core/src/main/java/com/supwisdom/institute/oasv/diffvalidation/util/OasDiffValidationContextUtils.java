package com.supwisdom.institute.oasv.diffvalidation.util;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;

public class OasDiffValidationContextUtils {

  private static final String IN_REQUEST_BODY = OasDiffValidationContextUtils.class.getName() + ".IN_REQUEST_BODY";
  private static final String IN_PARAMETER = OasDiffValidationContextUtils.class.getName() + ".IN_PARAMETER";
  private static final String IN_RESPONSE = OasDiffValidationContextUtils.class.getName() + ".IN_RESPONSE";

  public static void enterRequestBody(OasDiffValidationContext context) {
    context.setAttribute(IN_REQUEST_BODY, true);
  }

  public static void leaveRequestBody(OasDiffValidationContext context) {
    context.removeAttribute(IN_REQUEST_BODY);
  }

  public static void enterResponse(OasDiffValidationContext context) {
    context.setAttribute(IN_RESPONSE, true);
  }

  public static void leaveResponse(OasDiffValidationContext context) {
    context.removeAttribute(IN_RESPONSE);
  }

  public static void enterParameter(OasDiffValidationContext context) {
    context.setAttribute(IN_PARAMETER, true);
  }

  public static void leaveParameter(OasDiffValidationContext context) {
    context.removeAttribute(IN_PARAMETER);
  }

  public static boolean isInRequestBody(OasDiffValidationContext context) {
    return Boolean.TRUE.equals(context.getAttribute(IN_REQUEST_BODY));
  }

  public static boolean isInResponse(OasDiffValidationContext context) {
    return Boolean.TRUE.equals(context.getAttribute(IN_RESPONSE));
  }

  public static boolean isInParameter(OasDiffValidationContext context) {
    return Boolean.TRUE.equals(context.getAttribute(IN_PARAMETER));
  }

}
