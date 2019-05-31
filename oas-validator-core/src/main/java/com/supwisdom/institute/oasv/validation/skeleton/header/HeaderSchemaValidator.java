package com.supwisdom.institute.oasv.validation.skeleton.header;

import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.HeaderValidator;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#headerObject">Header Object</a>校验器
 * .schema属性校验器
 */
public class HeaderSchemaValidator extends ObjectPropertyValidator<Header, Schema> implements HeaderValidator {

  public HeaderSchemaValidator(List<SchemaValidator> oasObjectValidators) {
    super(oasObjectValidators);
  }

  @Override
  protected String get$ref(Header oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected Schema getPropertyObject(Header oasObject) {
    return oasObject.getSchema();
  }

  @Override
  protected String getPropertyName() {
    return "schema";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return SCHEMA;
  }
}
