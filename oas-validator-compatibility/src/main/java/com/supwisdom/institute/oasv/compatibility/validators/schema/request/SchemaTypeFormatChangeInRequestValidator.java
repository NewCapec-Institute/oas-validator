package com.supwisdom.institute.oasv.compatibility.validators.schema.request;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaTypeFormatChangeValidator;
import com.supwisdom.institute.oasv.compatibility.validators.schema.TypeFormat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInParameter;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInRequestBody;

public class SchemaTypeFormatChangeInRequestValidator extends SchemaTypeFormatChangeValidator {

  private static final List<Object[]> allowedChangedList;

  static {
    Object[][] allowedChange = new Object[][] {
      new Object[] { new TypeFormat("integer", null), new TypeFormat("integer", "int64") },
      new Object[] { new TypeFormat("integer", null), new TypeFormat("number", "double") },
      new Object[] { new TypeFormat("integer", null), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("integer", "int64") },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("integer", null) },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("number", "float") },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("number", "double") },
      new Object[] { new TypeFormat("integer", "int32"), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("integer", null) },
      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("number", "double") },
      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("number", null), new TypeFormat("number", "double") },

      new Object[] { new TypeFormat("number", "float"), new TypeFormat("number", null) },
      new Object[] { new TypeFormat("number", "float"), new TypeFormat("number", "double") },

      new Object[] { new TypeFormat("number", "double"), new TypeFormat("number", null) },

      new Object[] { new TypeFormat("string", null), new TypeFormat("string", "password") },

      new Object[] { new TypeFormat("string", "password"), new TypeFormat("string", null) },
    };
    allowedChangedList = Collections.unmodifiableList(Arrays.asList(allowedChange));
  }

  @Override
  protected List<Object[]> getAllowedChangedList() {
    return allowedChangedList;
  }

  @Override
  protected boolean needValidate(OasDiffValidationContext context) {
    return isInRequestBody(context) || isInParameter(context);
  }

}
