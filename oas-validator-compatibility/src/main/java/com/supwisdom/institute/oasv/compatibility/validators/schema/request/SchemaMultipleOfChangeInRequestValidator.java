package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;

import java.math.BigDecimal;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;

public class SchemaMultipleOfChangeInRequestValidator extends SchemaPropertyChangeValidator<BigDecimal> {

  @Override
  protected BigDecimal getProperty(Schema schema) {
    return schema.getMultipleOf();
  }

  @Override
  protected String getPropertyName() {
    return "multipleOf";
  }

  @Override
  protected String getMessage(BigDecimal leftProperty, BigDecimal rightProperty) {
    return "新值必须==旧值或是旧值的因子";
  }

  @Override
  protected boolean isAllowed(BigDecimal leftProperty, BigDecimal rightProperty) {
    return BigDecimal.ZERO.compareTo(leftProperty.divideAndRemainder(rightProperty)[1]) == 0;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInParameter(context) || isInRequestBody(context);
  }

}
