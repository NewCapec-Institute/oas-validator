package com.supwisdom.institute.oasv.validation.skeleton.schema;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import io.swagger.v3.oas.models.media.ArraySchema;
import io.swagger.v3.oas.models.media.ComposedSchema;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;
import static com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils.doValidateListProperty;
import static com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils.doValidateMapPropertyValues;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * 递归检查当前Schema Object及其properties下的所有Sub Schema Object
 */
public abstract class SchemaRecursiveValidatorTemplate implements SchemaValidator {

  @Override
  public final List<OasViolation> validate(OasValidationContext context, OasObjectPropertyLocation location,
    Schema oasObject) {

    if (StringUtils.isNotBlank(oasObject.get$ref())) {
      return emptyList();
    }
    if (oasObject instanceof ComposedSchema) {
      return validateComposedSchema(context, (ComposedSchema) oasObject, location);
    }
    if (oasObject instanceof ArraySchema) {
      return validateArraySchema(context, (ArraySchema) oasObject, location);
    }
    return validateOrdinarySchema(context, oasObject, location);

  }

  private List<OasViolation> validateOrdinarySchema(OasValidationContext context, Schema oasObject,
    OasObjectPropertyLocation location) {

    List<OasViolation> violations = new ArrayList<>();
    violations.addAll(validateCurrentSchemaObject(context, oasObject, location));

    violations.addAll(
      doValidateMapPropertyValues(
        context,
        location,
        "properties",
        oasObject.getProperties(),
        SCHEMA,
        singletonList(this)
      )
    );

    return violations;

  }

  private List<OasViolation> validateArraySchema(OasValidationContext context, ArraySchema oasObject,
    OasObjectPropertyLocation location) {
    return validate(context, location.property("items", SCHEMA), oasObject.getItems());
  }

  private List<OasViolation> validateComposedSchema(OasValidationContext context, ComposedSchema oasObject,
    OasObjectPropertyLocation location) {

    List<OasViolation> violations = new ArrayList<>();

    violations.addAll(
      doValidateListProperty(
        context, location,
        "allOf",
        oasObject.getAllOf(),
        SCHEMA,
        singletonList(this)
      )
    );

    violations.addAll(
      doValidateListProperty(
        context, location,
        "anyOf",
        oasObject.getAnyOf(),
        SCHEMA,
        singletonList(this)
      )
    );

    violations.addAll(
      doValidateListProperty(
        context, location,
        "oneOf",
        oasObject.getOneOf(),
        SCHEMA,
        singletonList(this)
      )
    );

    return violations;
  }

  protected abstract List<OasViolation> validateCurrentSchemaObject(OasValidationContext context, Schema oasObject,
    OasObjectPropertyLocation location);

}
