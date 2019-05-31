package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;
import static java.util.Collections.emptyList;

public class SchemaRequiredChangeInRequestValidator extends SchemaPropertyChangeValidator<List<String>> {

  @Override
  protected List<String> getProperty(Schema schema) {
    return ObjectUtils.defaultIfNull(schema.getRequired(), emptyList());
  }

  @Override
  protected String getPropertyName() {
    return "required";
  }

  @Override
  protected boolean isAllowed(List<String> leftProperty, List<String> rightProperty) {
    return leftProperty.containsAll(rightProperty);
  }

  @Override
  protected String getMessage(List<String> leftProperty, List<String> rightProperty) {
    return "不允许新增required字段";
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInParameter(context) || isInRequestBody(context);
  }

}
