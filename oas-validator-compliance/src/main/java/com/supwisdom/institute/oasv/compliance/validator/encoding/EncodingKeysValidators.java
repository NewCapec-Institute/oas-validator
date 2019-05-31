package com.supwisdom.institute.oasv.compliance.validator.encoding;

import com.supwisdom.institute.oasv.util.StringCaseUtils;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.skeleton.encoding.EncodingHeadersKeysValidator;

public abstract class EncodingKeysValidators {

  public static final EncodingHeadersKeysValidator HEADERS_UPPER_HYPHEN_CASE_VALIDATOR = new EncodingHeadersKeysValidator(
    key -> StringCaseUtils.isUpperHyphenCase(key),
    key -> ViolationMessages.UPPER_HYPHEN_CASE
  );

}
