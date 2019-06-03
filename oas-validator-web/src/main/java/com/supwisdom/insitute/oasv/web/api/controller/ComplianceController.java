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

import com.supwisdom.insitute.oasv.web.api.vo.ComplianceYamlRequest;
import com.supwisdom.institute.oasv.validation.api.OasSpecValidator;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import io.swagger.v3.parser.core.models.ParseOptions;
import io.swagger.v3.parser.core.models.SwaggerParseResult;
//import io.swagger.v3.parser.util.ClasspathHelper;

@RestController
@RequestMapping("/api/compliance")
public class ComplianceController {
  
  @Autowired
  private OasSpecValidator oasSpecValidator;
  

  @PostMapping(consumes = MimeTypeUtils.TEXT_PLAIN_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public Map<String, Object> validateOpenAPI(@RequestBody String yaml) {
    
    //String yaml = ClasspathHelper.loadFileFromClasspath("/samples/petstore-openapi-wrong.yaml");
    //String yaml = complianceYamlRequest.getYaml();
    
    OpenAPI openAPI = loadByYaml(yaml);
    
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);

    Map<String, Object> data = new HashMap<>();
    data.put("violations", violations);

    Map<String, Object> json = new HashMap<>();
    
    json.put("acknowleged", true);
    json.put("data", data);
    
    return json;
  }
  
  
  @PostMapping(consumes = MimeTypeUtils.APPLICATION_JSON_VALUE, produces = MimeTypeUtils.APPLICATION_JSON_VALUE)
  @ResponseStatus(value = HttpStatus.OK)
  public Map<String, Object> validateOpenAPI(@RequestBody ComplianceYamlRequest complianceYamlRequest) {
    
    //String yaml = ClasspathHelper.loadFileFromClasspath("/samples/petstore-openapi-wrong.yaml");
    String yaml = complianceYamlRequest.getYaml();
    
    OpenAPI openAPI = loadByYaml(yaml);
    
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);

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
    parseOptions.setResolveCombinators(false);
    parseOptions.setResolveFully(false);
    parseOptions.setFlatten(false);
    return parseOptions;

  }
  
  private OasValidationContext createContext(OpenAPI openAPI) {

    OasValidationContext oasValidationContext = new OasValidationContext(openAPI);
    initContext(oasValidationContext);
    return oasValidationContext;

  }
  
  
  private void initContext(OasValidationContext context) {
  }
}
