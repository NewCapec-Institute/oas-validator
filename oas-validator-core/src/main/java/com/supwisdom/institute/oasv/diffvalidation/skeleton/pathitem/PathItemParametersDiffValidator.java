package com.supwisdom.institute.oasv.diffvalidation.skeleton.pathitem;

import com.supwisdom.institute.oasv.diffvalidation.api.ListPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.ParameterDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.PathItemDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.PARAMETER;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#pathItemObject">Path Item Object</a>
 * .parameters (List of <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#parameterObject">Parameter Object</a>)的校验器
 */
public class PathItemParametersDiffValidator
  extends ListPropertyDiffValidator<PathItem, Parameter>
  implements PathItemDiffValidator {

  public PathItemParametersDiffValidator(List<ParameterDiffValidator> parameterValidators) {
    super(parameterValidators, parameter -> "in:" + parameter.getIn() + "/name:" + parameter.getName());
  }

  @Override
  protected List<Parameter> getListProperty(PathItem oasObject) {
    return oasObject.getParameters();
  }

  @Override
  protected String getListPropertyName() {
    return "parameters";
  }

  @Override
  protected OasObjectType getElementType() {
    return PARAMETER;
  }

}
