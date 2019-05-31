package com.supwisdom.institute.oasv.compatibility.validators.schema.response;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaPropertyChangeValidator;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.ObjectUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInResponse;
import static java.util.Collections.emptyList;

public class SchemaEnumChangeInResponseValidator extends SchemaPropertyChangeValidator<List> {

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
    return leftProperty.containsAll(rightProperty);
  }

  @Override
  protected String getMessage(List leftProperty, List rightProperty) {
    return "不允许新增enum";
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInResponse(context);
  }

}
