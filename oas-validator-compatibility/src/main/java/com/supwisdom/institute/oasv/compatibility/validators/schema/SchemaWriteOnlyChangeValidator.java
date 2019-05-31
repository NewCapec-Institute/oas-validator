package com.supwisdom.institute.oasv.compatibility.validators.schema;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.ObjectUtils;

public class SchemaWriteOnlyChangeValidator extends SchemaPropertyChangeValidator<Boolean> {

  @Override
  protected Boolean getProperty(Schema schema) {
    return ObjectUtils.defaultIfNull(schema.getWriteOnly(), Boolean.FALSE);
  }

  @Override
  protected String getPropertyName() {
    return "writeOnly";
  }

  @Override
  protected boolean isAllowed(Boolean leftProperty, Boolean rightProperty) {
    return leftProperty.equals(rightProperty);
  }

  @Override
  protected String getMessage(Boolean leftProperty, Boolean rightProperty) {
    return DiffViolationMessages.NEW_NOT_EQ_OLD;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return true;
  }

}
