package com.supwisdom.institute.oasv.compatibility.validators.schema.response;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;

import java.math.BigDecimal;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.*;

public class SchemaMinimumChangeInResponseValidator extends SchemaPropertyChangeValidator<BigDecimal> {

  @Override
  protected BigDecimal getProperty(Schema schema) {
    return schema.getMinimum();
  }

  @Override
  protected String getPropertyName() {
    return "minimum";
  }

  @Override
  protected boolean isAllowed(BigDecimal leftProperty, BigDecimal rightProperty) {
    return rightProperty.compareTo(leftProperty) >= 0;
  }

  @Override
  protected String getMessage(BigDecimal leftProperty, BigDecimal rightProperty) {
    return DiffViolationMessages.NEW_NOT_GTE_OLD;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInResponse(context);
  }

}
