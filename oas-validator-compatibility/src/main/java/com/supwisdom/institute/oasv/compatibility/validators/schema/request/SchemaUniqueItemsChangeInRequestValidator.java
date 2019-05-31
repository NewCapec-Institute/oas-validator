package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.util.ChangeRangeCheckUtils;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;
import static java.util.Collections.singletonList;

public class SchemaUniqueItemsChangeInRequestValidator extends SchemaPropertyChangeValidator<Boolean> {

  @Override
  protected Boolean getProperty(Schema schema) {
    return schema.getUniqueItems();
  }

  @Override
  protected String getPropertyName() {
    return "uniqueItems";
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
