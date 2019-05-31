package com.supwisdom.institute.oasv.compatibility.validators.schema;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import io.swagger.v3.oas.models.media.Discriminator;
import io.swagger.v3.oas.models.media.Schema;

public class SchemaDiscriminatorChangeValidator extends SchemaPropertyChangeValidator<Discriminator> {

  @Override
  protected Discriminator getProperty(Schema schema) {
    return schema.getDiscriminator();
  }

  @Override
  protected String getPropertyName() {
    return "discriminator";
  }

  @Override
  protected boolean isAllowed(Discriminator leftProperty, Discriminator rightProperty) {
    return leftProperty.equals(rightProperty);
  }

  @Override
  protected String getMessage(Discriminator leftProperty, Discriminator rightProperty) {
    return DiffViolationMessages.NEW_NOT_EQ_OLD;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return true;
  }

}
