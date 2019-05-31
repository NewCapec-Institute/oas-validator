package com.supwisdom.institute.oasv.validation.skeleton.parameter;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ParameterValidator;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import com.supwisdom.institute.oasv.validation.api.ObjectPropertyValidator;
import io.swagger.v3.oas.models.media.Schema;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#parameterObject">Parameter Object</a>属性校验器
 * .schema属性校验器
 */
public class ParameterSchemaValidator extends ObjectPropertyValidator<Parameter, Schema>
  implements ParameterValidator {

  public ParameterSchemaValidator(
    List<SchemaValidator> schemaValidators) {
    super(schemaValidators);
  }

  @Override
  protected String get$ref(Parameter oasObject) {
    return oasObject.get$ref();
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
