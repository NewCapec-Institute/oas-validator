package com.supwisdom.institute.oasv.util;

import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

public abstract class OasSpecParser {

  private OasSpecParser() {
    // singleton
  }

  public static SwaggerParseResult parse(String oasSpecContent, ParseOptions parseOptions) {
    OpenAPIV3Parser parser = new OpenAPIV3Parser();
    SwaggerParseResult swaggerParseResult = parser.readContents(oasSpecContent, null, parseOptions);
    return swaggerParseResult;
  }

}
