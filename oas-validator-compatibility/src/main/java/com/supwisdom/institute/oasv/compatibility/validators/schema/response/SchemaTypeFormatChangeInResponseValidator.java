package com.supwisdom.institute.oasv.compatibility.validators.schema.response;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaTypeFormatChangeValidator;
import com.supwisdom.institute.oasv.compatibility.validators.schema.TypeFormat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.isInResponse;

public class SchemaTypeFormatChangeInResponseValidator extends SchemaTypeFormatChangeValidator {

  private static final List<Object[]> allowedChangedList;

  static {
    Object[][] allowedChange = new Object[][] {
      new Object[] { new TypeFormat("integer", null), new TypeFormat("integer", "int64") },
      new Object[] { new TypeFormat("integer", null), new TypeFormat("integer", "int32") },

      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("integer", null) },
      new Object[] { new TypeFormat("integer", "int64"), new TypeFormat("integer", "int32") },

      new Object[] { new TypeFormat("number", null), new TypeFormat("number", "double") },
      new Object[] { new TypeFormat("number", null), new TypeFormat("number", "float") },

      new Object[] { new TypeFormat("number", "double"), new TypeFormat("number", null) },
      new Object[] { new TypeFormat("number", "double"), new TypeFormat("number", "float") },

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
    return isInResponse(context);
  }

}
