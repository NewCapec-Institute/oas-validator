package com.supwisdom.institute.oasv.validation.skeleton.pathitem;

import com.supwisdom.institute.oasv.validation.api.ParameterValidator;
import com.supwisdom.institute.oasv.validation.api.ListPropertyValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.PathItemValidator;
import io.swagger.v3.oas.models.PathItem;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.PARAMETER;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#pathItemObject">Path Item Object</a>
 * .parameters (List of <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#parameterObject">Parameter Object</a>)的校验器
 */
public class PathItemParametersValidator extends ListPropertyValidator<PathItem, Parameter>
  implements PathItemValidator {

  public PathItemParametersValidator(List<ParameterValidator> parameterValidators) {
    super(parameterValidators);
  }

  @Override
  protected String get$ref(PathItem oasObject) {
    return oasObject.get$ref();
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
