package com.supwisdom.institute.oasv.diffvalidation.skeleton.openapi;

import com.supwisdom.institute.oasv.diffvalidation.api.ListPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OpenApiDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ServerDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SERVER;

public class OpenApiServersDiffValidator
  extends ListPropertyDiffValidator<OpenAPI, Server>
  implements OpenApiDiffValidator {

  public OpenApiServersDiffValidator(List<ServerDiffValidator> diffValidators) {
    super(diffValidators, server -> server.getUrl());
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
