package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;
import static java.util.Collections.emptyList;

public class SchemaEnumChangeInRequestValidator extends SchemaPropertyChangeValidator<List> {

  @Override
  protected List getProperty(Schema schema) {
    return ObjectUtils.defaultIfNull(schema.getEnum(), emptyList());
  }

  @Override
  protected String getPropertyName() {
    return "enum";
  }

  @Override
  protected boolean isAllowed(List leftProperty, List rightProperty) {
    return rightProperty.containsAll(leftProperty);
  }

  @Override
  protected String getMessage(List leftProperty, List rightProperty) {
    return "不允许删除enum";
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInParameter(context) || isInRequestBody(context);
  }

}
