package com.supwisdom.institute.oasv.diffvalidation.skeleton.mediatype;

import com.supwisdom.institute.oasv.diffvalidation.api.MediaTypeDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.SchemaDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;

public class MediaTypeSchemaDiffValidator
  extends ObjectPropertyDiffValidator<MediaType, Schema> implements
  MediaTypeDiffValidator {

  public MediaTypeSchemaDiffValidator(List<SchemaDiffValidator> oasObjectValidators) {
    super(oasObjectValidators);
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
