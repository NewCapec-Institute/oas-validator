package com.supwisdom.institute.oasv.compatibility.validators;

import com.supwisdom.institute.oasv.diffvalidation.test.OasDiffValidatorTestBase;
import io.swagger.v3.parser.core.models.ParseOptions;

public class OasCompatibilityTestBase extends OasDiffValidatorTestBase {

  @Override
  protected ParseOptions createParseOptions() {

    ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setResolveCombinators(true);
    parseOptions.setResolveFully(true);
    parseOptions.setFlatten(false);
    return parseOptions;

  }

}
