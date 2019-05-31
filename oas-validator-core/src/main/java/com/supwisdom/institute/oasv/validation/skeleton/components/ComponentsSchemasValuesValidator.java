package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.media.Schema;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;

public class ComponentsSchemasValuesValidator extends MapPropertyValuesValidator<Components, Schema>
  implements ComponentsValidator {

  public ComponentsSchemasValuesValidator(List<SchemaValidator> valueValidators) {
    super(valueValidators);
  }
  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }
  @Override
  protected Map<String, Schema> getMapProperty(Components components) {
    return components.getSchemas();
  }

  @Override
  protected String getMapPropertyName() {
    return "schemas";
  }

  @Override
  protected OasObjectType getValueType() {
    return SCHEMA;
  }

}
