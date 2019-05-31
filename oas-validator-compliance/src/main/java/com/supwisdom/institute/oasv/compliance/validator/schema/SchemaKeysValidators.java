package com.supwisdom.institute.oasv.compliance.validator.schema;

import com.supwisdom.institute.oasv.util.StringCaseUtils;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.skeleton.schema.SchemaPropertiesKeysValidator;

public class SchemaKeysValidators {

  public static final SchemaPropertiesKeysValidator PROPERTIES_LOWER_CAMEL_CASE_VALIDATOR = new SchemaPropertiesKeysValidator(
    key -> StringCaseUtils.isLowerCamelCase(key),
    key -> ViolationMessages.LOWER_CAMEL_CASE
  );

}
