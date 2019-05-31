package com.supwisdom.institute.oasv.compatibility.validators.schema;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.SchemaCompareValidator;
import com.supwisdom.institute.oasv.diffvalidation.util.ChangeRangeCheckUtils;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public abstract class SchemaTypeFormatChangeValidator implements SchemaCompareValidator {

  @Override
  public final List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    Schema leftOasObject, OasObjectPropertyLocation rightLocation, Schema rightOasObject) {

    if (!needValidate(context)) {
      return emptyList();
    }

    TypeFormat leftTypeFormat = new TypeFormat(leftOasObject);
    TypeFormat rightTypeFormat = new TypeFormat(rightOasObject);

    if (ChangeRangeCheckUtils.isNotViolated(leftTypeFormat, rightTypeFormat, getAllowedChangedList())) {
      return emptyList();
    }

    StringBuilder message = new StringBuilder("不允许");
    message
      .append("(type=")
      .append(leftTypeFormat.getType())
      .append(",format=")
      .append(leftTypeFormat.getFormat())
      .append(')')
      .append("->")
      .append("(type=")
      .append(rightTypeFormat.getType())
      .append(",format=")
      .append(rightTypeFormat.getFormat())
      .append(')')
      .append("的修改");

    return singletonList(new OasDiffViolation(leftLocation, rightLocation, message.toString()));

  }

  protected abstract List<Object[]> getAllowedChangedList();

  protected abstract boolean needValidate(OasDiffValidationContext context);

}
