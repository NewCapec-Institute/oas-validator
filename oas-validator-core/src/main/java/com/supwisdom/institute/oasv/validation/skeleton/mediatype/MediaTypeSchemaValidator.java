package com.supwisdom.institute.oasv.validation.skeleton.mediatype;

import com.supwisdom.institute.oasv.validation.api.MediaTypeValidator;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#media-type-object">Media Type Object</a>
 * .schema属性校验器
 */
public class MediaTypeSchemaValidator extends ObjectPropertyValidator<MediaType, Schema>
  implements MediaTypeValidator {

  public MediaTypeSchemaValidator(List<SchemaValidator> schemaValidators) {
    super(schemaValidators);
  }

  @Override
  protected String get$ref(MediaType oasObject) {
    return null;
  }

  @Override
  protected Schema getPropertyObject(MediaType oasObject) {
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
