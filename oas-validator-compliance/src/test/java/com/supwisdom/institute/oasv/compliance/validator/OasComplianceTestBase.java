package com.supwisdom.institute.oasv.compliance.validator;

import com.supwisdom.institute.oasv.validation.test.OasValidatorTestBase;
import io.swagger.v3.parser.core.models.ParseOptions;

public class OasComplianceTestBase extends OasValidatorTestBase {

  @Override
  protected ParseOptions createParseOptions() {

    ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setResolveCombinators(false);
    parseOptions.setResolveFully(false);
    parseOptions.setFlatten(false);
    return parseOptions;

  }
}
