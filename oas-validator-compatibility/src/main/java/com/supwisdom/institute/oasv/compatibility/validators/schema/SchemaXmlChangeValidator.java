package com.supwisdom.institute.oasv.compatibility.validators.schema;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.media.XML;

public class SchemaXmlChangeValidator extends SchemaPropertyChangeValidator<XML> {

  @Override
  protected XML getProperty(Schema schema) {
    return schema.getXml();
  }

  @Override
  protected String getPropertyName() {
    return "xml";
  }

  @Override
  protected boolean isAllowed(XML leftProperty, XML rightProperty) {
    return leftProperty.equals(rightProperty);
  }

  @Override
  protected String getMessage(XML leftProperty, XML rightProperty) {
    return DiffViolationMessages.NEW_NOT_EQ_OLD;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return true;
  }

}
