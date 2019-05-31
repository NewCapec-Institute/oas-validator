package com.supwisdom.institute.oasv.validation.skeleton.openapi;

import com.supwisdom.institute.oasv.validation.api.InfoValidator;
import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import java.util.List;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .info (<a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#infoObject">Info Object</a>)校验器
 */
public class OpenApiInfoValidator extends ObjectPropertyValidator<OpenAPI, Info>
  implements OpenApiValidator {

  public OpenApiInfoValidator(List<InfoValidator> infoValidators) {
    super(infoValidators);
  }

  @Override
  protected String get$ref(OpenAPI oasObject) {
    return null;
  }

  @Override
  protected Info getPropertyObject(OpenAPI oasObject) {
    return oasObject.getInfo();
  }

  @Override
  protected String getPropertyName() {
    return "info";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return OasObjectType.INFO;
  }

}
