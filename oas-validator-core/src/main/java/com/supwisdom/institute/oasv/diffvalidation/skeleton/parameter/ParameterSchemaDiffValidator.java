package com.supwisdom.institute.oasv.diffvalidation.skeleton.parameter;

import com.supwisdom.institute.oasv.diffvalidation.api.*;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;
import static com.supwisdom.institute.oasv.diffvalidation.util.OasDiffValidationContextUtils.*;

public class ParameterSchemaDiffValidator
  extends ObjectPropertyDiffValidator<Parameter, Schema>
  implements ParameterDiffValidator {

  public ParameterSchemaDiffValidator(List<SchemaDiffValidator> schemaDiffValidators) {
    super(schemaDiffValidators);
  }

  @Override
  public List<OasDiffViolation> validate(OasDiffValidationContext context, OasObjectPropertyLocation leftLocation,
    Parameter leftOasObject, OasObjectPropertyLocation rightLocation, Parameter rightOasObject) {

    enterParameter(context);

    List<OasDiffViolation> violations = super
      .validate(context, leftLocation, leftOasObject, rightLocation, rightOasObject);

    leaveParameter(context);
    return violations;
  }

  @Override
  protected Schema getPropertyObject(Parameter oasObject) {
    return oasObject.getSchema();
  }

  @Override
  protected String getPropertyName() {
    return "schema";
  }

  @Override
  protected OasObjectType getPropertyType() {
    return SCHEMA;
  }

}
