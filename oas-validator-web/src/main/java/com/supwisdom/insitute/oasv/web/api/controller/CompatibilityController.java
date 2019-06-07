package com.supwisdom.insitute.oasv.web.api.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.supwisdom.insitute.oasv.web.api.vo.CompatibilityYamlRequest;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasSpecDiffValidator;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;

@RestController
@RequestMapping("/api/compatibility")
public class CompatibilityController {
  
  @Autowired
  private OasSpecDiffValidator oasSpecDiffValidator;
  

  @PostMapping(consumes = MimeTypeUtils.TEXT_PLAIN_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public Map<String, Object> validateOpenAPI(@RequestBody String yaml) {
    
    //String leftYaml = compatibilityYamlRequest.getLeftYaml();
    //String rightYaml = compatibilityYamlRequest.getRightYaml();
    String leftYaml = yaml.split("---\n")[0];
    String rightYaml = yaml.split("---\n")[1];
    
    OpenAPI leftOpenAPI = loadByYaml(leftYaml);
    OpenAPI rightOpenAPI = loadByYaml(rightYaml);
    
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    Map<String, Object> data = new HashMap<>();
    data.put("violations", violations);

    Map<String, Object> json = new HashMap<>();
    
    json.put("acknowleged", true);
    json.put("data", data);
    
    return json;
  }
  
  
  @PostMapping(consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public Map<String, Object> validateOpenAPI(@RequestBody CompatibilityYamlRequest compatibilityYamlRequest) {
    
    String leftYaml = compatibilityYamlRequest.getLeftYaml();
    String rightYaml = compatibilityYamlRequest.getRightYaml();
    
    OpenAPI leftOpenAPI = loadByYaml(leftYaml);
    OpenAPI rightOpenAPI = loadByYaml(rightYaml);
    
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    Map<String, Object> data = new HashMap<>();
    data.put("violations", violations);

    Map<String, Object> json = new HashMap<>();
    
    json.put("acknowleged", true);
    json.put("data", data);
    
    return json;
  }
  
  
  private OpenAPI loadByYaml(String yaml) {
    OpenAPIV3Parser parser = new OpenAPIV3Parser();
    SwaggerParseResult parseResult = parser.readContents(yaml, null, createParseOptions());
    if (CollectionUtils.isNotEmpty(parseResult.getMessages())) {
      throw new RuntimeException(StringUtils.join(parseResult.getMessages(), ","));
    }
    return parseResult.getOpenAPI();
  }

  private ParseOptions createParseOptions() {

    ParseOptions parseOptions = new ParseOptions();
    parseOptions.setResolve(true);
    parseOptions.setResolveCombinators(true);
    parseOptions.setResolveFully(true);
    parseOptions.setFlatten(false);
    return parseOptions;

  }
  
  private OasDiffValidationContext createContext(OpenAPI leftOpenAPI, OpenAPI rightOpenAPI) {

    OasDiffValidationContext context = new OasDiffValidationContext(leftOpenAPI, rightOpenAPI);
    initContext(context);
    return context;

  }
  
  
  private void initContext(OasDiffValidationContext context) {
  }

}
