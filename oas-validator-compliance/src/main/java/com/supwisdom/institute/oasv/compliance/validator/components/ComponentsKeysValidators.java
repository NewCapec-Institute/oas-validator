package com.supwisdom.institute.oasv.compliance.validator.components;

import com.supwisdom.institute.oasv.util.StringCaseUtils;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.skeleton.components.*;

public abstract class ComponentsKeysValidators {

  public static final ComponentsCallbacksKeysValidator CALLBACKS_UPPER_CAMEL_CASE_VALIDATOR = new ComponentsCallbacksKeysValidator(
    key -> StringCaseUtils.isUpperCamelCase(key),
    key -> ViolationMessages.UPPER_CAMEL_CASE
  );
  public static final ComponentsExamplesKeysValidator EXAMPLES_UPPER_CAMEL_CASE_VALIDATOR = new ComponentsExamplesKeysValidator(
    key -> StringCaseUtils.isUpperCamelCase(key),
    key -> ViolationMessages.UPPER_CAMEL_CASE
  );
  public static final ComponentsHeadersKeysValidator HEADERS_UPPER_HYPHEN_CASE_VALIDATOR = new ComponentsHeadersKeysValidator(
    key -> StringCaseUtils.isUpperHyphenCase(key),
    key -> ViolationMessages.UPPER_HYPHEN_CASE
  );
  public static final ComponentsLinksKeysValidator LINKS_UPPER_CAMEL_CASE_VALIDATOR = new ComponentsLinksKeysValidator(
    key -> StringCaseUtils.isUpperCamelCase(key),
    key -> ViolationMessages.UPPER_CAMEL_CASE
  );
  public static final ComponentsParametersKeysValidator PARAMETERS_UPPER_CAMEL_CASE_VALIDATOR = new ComponentsParametersKeysValidator(
    key -> StringCaseUtils.isUpperCamelCase(key),
    key -> ViolationMessages.UPPER_CAMEL_CASE
  );
  public static final ComponentsRequestBodiesKeysValidator REQUEST_BODIES_UPPER_CAMEL_CASE_VALIDATOR = new ComponentsRequestBodiesKeysValidator(
    key -> StringCaseUtils.isUpperCamelCase(key),
    key -> ViolationMessages.UPPER_CAMEL_CASE
  );
  public static final ComponentsResponsesKeysValidator RESPONSES_UPPER_CAMEL_CASE_VALIDATOR = new ComponentsResponsesKeysValidator(
    key -> StringCaseUtils.isUpperCamelCase(key),
    key -> ViolationMessages.UPPER_CAMEL_CASE
  );
  public static final ComponentsSchemasKeysValidator SCHEMAS_UPPER_CAMEL_CASE_VALIDATOR = new ComponentsSchemasKeysValidator(
    key -> StringCaseUtils.isUpperCamelCase(key),
    key -> ViolationMessages.UPPER_CAMEL_CASE
  );

}
