package com.supwisdom.institute.oasv.diffvalidation.skeleton.header;

import com.supwisdom.institute.oasv.diffvalidation.api.HeaderDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ObjectPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.SchemaDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;

public class HeaderSchemaDiffValidator
  extends ObjectPropertyDiffValidator<Header, Schema>
  implements HeaderDiffValidator {

  public HeaderSchemaDiffValidator(List<SchemaDiffValidator> oasObjectValidators) {
    super(oasObjectValidators);
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
