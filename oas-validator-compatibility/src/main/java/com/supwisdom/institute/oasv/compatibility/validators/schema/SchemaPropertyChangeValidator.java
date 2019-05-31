package com.supwisdom.institute.oasv.compatibility.validators.schema;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffValidationContext;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.SchemaCompareValidator;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;
import java.util.Objects;

import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

public abstract class SchemaPropertyChangeValidator<T> implements SchemaCompareValidator {

  @Override
  public final List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    Schema leftOasObject, OasObjectPropertyLocation rightLocation, Schema rightOasObject) {

    if (!needValidate(context)) {
      return emptyList();
    }

    T leftNumber = getProperty(leftOasObject);
    T rightNumber = getProperty(rightOasObject);

    if (Objects.equals(leftNumber, rightNumber)) {
      return emptyList();
    }

    String propertyName = getPropertyName();

    if (leftNumber == null || rightNumber == null) {
      return singletonList(new OasDiffViolation(
          leftLocation.property(propertyName),
          rightLocation.property(propertyName),
          getMessage(leftNumber, rightNumber)
        )
      );
    }

    if (!isAllowed(leftNumber, rightNumber)) {
      return singletonList(new OasDiffViolation(
          leftLocation.property(propertyName),
          rightLocation.property(propertyName),
          getMessage(leftNumber, rightNumber)
        )
      );
    }

    return emptyList();

  }


  protected abstract T getProperty(Schema schema);

  protected abstract String getPropertyName();

  protected abstract String getMessage(T leftProperty, T rightProperty);

  protected abstract boolean isAllowed(T leftProperty, T rightProperty);

  protected abstract boolean needValidate(OasDiffValidationContext context);

}
