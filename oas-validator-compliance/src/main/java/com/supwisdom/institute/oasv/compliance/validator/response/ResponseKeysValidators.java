package com.supwisdom.institute.oasv.compliance.validator.response;

import com.supwisdom.institute.oasv.validation.skeleton.response.ResponseHeadersKeysValidator;

import static com.supwisdom.institute.oasv.util.StringCaseUtils.isUpperHyphenCase;
import static com.supwisdom.institute.oasv.validation.api.ViolationMessages.UPPER_HYPHEN_CASE;

public class ResponseKeysValidators {

  public static final ResponseHeadersKeysValidator HEADERS_UPPER_HYPHEN_CASE_VALIDATOR = new ResponseHeadersKeysValidator(
    key -> isUpperHyphenCase(key),
    key -> UPPER_HYPHEN_CASE
  );
}
