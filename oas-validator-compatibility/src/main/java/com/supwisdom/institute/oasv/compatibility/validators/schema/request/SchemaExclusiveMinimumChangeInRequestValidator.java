package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.util.ChangeRangeCheckUtils;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.ObjectUtils;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;
import static java.util.Collections.singletonList;

public class SchemaExclusiveMinimumChangeInRequestValidator extends SchemaPropertyChangeValidator<Boolean> {

  @Override
  protected Boolean getProperty(Schema schema) {
    return ObjectUtils.defaultIfNull(schema.getExclusiveMinimum(), Boolean.FALSE);
  }

  @Override
  protected String getPropertyName() {
    return "exclusiveMinimum";
  }

  @Override
  protected boolean isAllowed(Boolean leftProperty, Boolean rightProperty) {
    return ChangeRangeCheckUtils
      .isNotViolated(leftProperty, rightProperty, singletonList(new Object[] { true, false }));
  }

  @Override
  protected String getMessage(Boolean leftProperty, Boolean rightProperty) {
    return "仅允许true->false的修改";
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInParameter(context) || isInRequestBody(context);
  }

}
