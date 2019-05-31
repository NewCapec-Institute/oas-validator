package com.supwisdom.institute.oasv.validation.skeleton.openapi;

import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import com.supwisdom.institute.oasv.validation.api.ServerValidator;
import com.supwisdom.institute.oasv.validation.api.ListPropertyValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SERVER;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .servers(List of <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#serverObject">Server Object</a>)校验器
 */
public class OpenApiServersValidator extends ListPropertyValidator<OpenAPI, Server>
  implements OpenApiValidator {

  public OpenApiServersValidator(List<ServerValidator> serverValidators) {
    super(serverValidators);
  }

  @Override
  protected String get$ref(OpenAPI oasObject) {
    return null;
  }

  @Override
  protected List<Server> getListProperty(OpenAPI oasObject) {
    return oasObject.getServers();
  }

  @Override
  protected String getListPropertyName() {
    return "servers";
  }

  @Override
  protected OasObjectType getElementType() {
    return SERVER;
  }

}
