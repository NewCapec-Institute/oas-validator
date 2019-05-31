package com.supwisdom.institute.oasv.util;

import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

import java.util.List;

import static java.util.Collections.emptyList;

public class DefaultOasSpecSyntaxChecker implements OasSpecSyntaxChecker {

  @Override
  public List<String> check(String oasSpecContent) {

    ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(false);
    parseOptions.setResolveFully(false);
    parseOptions.setResolveCombinators(false);
    parseOptions.setFlatten(false);
    SwaggerParseResult result = OasSpecParser.parse(oasSpecContent, parseOptions);
    return result.getMessages() == null ? emptyList() : result.getMessages();

  }

}
