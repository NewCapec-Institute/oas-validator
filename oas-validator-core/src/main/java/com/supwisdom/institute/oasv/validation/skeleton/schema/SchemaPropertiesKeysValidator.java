package com.supwisdom.institute.oasv.validation.skeleton.schema;

import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.OasValidationContext;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.util.OasObjectValidatorUtils;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.collections4.MapUtils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.util.Collections.emptyList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#schemaObject">Schema Object</a>
 * .properties属性keys校验器
 */
public class SchemaPropertiesKeysValidator
  extends SchemaRecursiveValidatorTemplate {

  private final Predicate<String> keyPredicate;

  private final Function<String, String> errorFunction;

  public SchemaPropertiesKeysValidator(Predicate<String> keyPredicate,
    Function<String, String> errorFunction) {
    this.keyPredicate = keyPredicate;
    this.errorFunction = errorFunction;
  }

  @Override
  protected List<OasViolation> validateCurrentSchemaObject(OasValidationContext context, Schema oasObject,
    OasObjectPropertyLocation location) {

    Map<String, Schema> properties = oasObject.getProperties();

    if (MapUtils.isEmpty(properties)) {
      return emptyList();
    }

    return
      OasObjectValidatorUtils.doValidateMapPropertyKeys(
        location,
        "properties",
        properties,
        keyPredicate,
        errorFunction
      );

  }
}
