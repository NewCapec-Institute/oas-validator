package com.supwisdom.institute.oasv.compatibility.validators.schema.response;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInResponse;

public class SchemaMinLengthChangeInResponseValidator extends SchemaPropertyChangeValidator<Integer> {

  @Override
  protected Integer getProperty(Schema schema) {
    return schema.getMinLength();
  }

  @Override
  protected String getPropertyName() {
    return "minLength";
  }

  @Override
  protected boolean isAllowed(Integer leftProperty, Integer rightProperty) {
    return rightProperty.compareTo(leftProperty) >= 0;
  }

  @Override
  protected String getMessage(Integer leftProperty, Integer rightProperty) {
    return DiffViolationMessages.NEW_NOT_GTE_OLD;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInResponse(context);
  }

}
