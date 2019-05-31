package com.supwisdom.institute.oasv.compliance.validator.schema;

import com.supwisdom.institute.oasv.common.OasObjectProperty;
import com.supwisdom.institute.oasv.common.OasObjectPropertyLocation;
import com.supwisdom.institute.oasv.validation.api.*;
import com.supwisdom.institute.oasv.validation.skeleton.schema.SchemaRecursiveValidatorTemplate;
import io.swagger.v3.oas.models.media.Schema;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.COMPONENTS;
import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#schemaObject">Schema Object</a>.title属性校验器
 * <ul>
 * <li>如果Schema Object的上级是
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#schemaObject">Schema Object</a>
 * /
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#componentsObject">Components Object</a>
 * ，那么必须写title</li>
 * </ul>
 */
public class SchemaTitleValidator extends SchemaRecursiveValidatorTemplate {

  @Override
  protected List<OasViolation> validateCurrentSchemaObject(OasValidationContext context, Schema oasObject,
    OasObjectPropertyLocation location) {

    if (StringUtils.isNotBlank(oasObject.get$ref())) {
      return emptyList();
    }

    OasObjectProperty parentProperty = location.getParent();

    if (SCHEMA == parentProperty.getObjectType()
      || COMPONENTS == parentProperty.getObjectType()
    ) {
      return check(oasObject, location);
    }

    return emptyList();

  }

  private List<OasViolation> check(Schema oasObject, OasObjectPropertyLocation location) {
    if (StringUtils.isNotBlank(oasObject.getTitle())) {
      return emptyList();
    }
    return singletonList(
      new OasViolation(location.property("title", null), ViolationMessages.REQUIRED));
  }
}
