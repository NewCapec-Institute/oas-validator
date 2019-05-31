package com.supwisdom.institute.oasv.diffvalidation.skeleton.operation;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.diffvalidation.api.ListPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OperationDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ParameterDiffValidator;
import io.swagger.v3.oas.models.Operation;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.PARAMETER;

public class OperationParametersDiffValidator
  extends ListPropertyDiffValidator<Operation, Parameter>
  implements OperationDiffValidator {

  public OperationParametersDiffValidator(List<ParameterDiffValidator> parameterValidators) {
    super(parameterValidators, parameter -> "in:" + parameter.getIn() + "/name:" + parameter.getName());
  }

  @Override
  protected List<Parameter> getListProperty(Operation oasObject) {
    return oasObject.getParameters();
  }

  protected String getListPropertyName() {
    return "parameters";
  }

  protected OasObjectType getElementType() {
    return PARAMETER;
  }

}
