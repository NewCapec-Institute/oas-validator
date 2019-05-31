package com.supwisdom.institute.oasv.validation.skeleton.openapi;

import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import com.supwisdom.institute.oasv.validation.api.TagValidator;
import com.supwisdom.institute.oasv.validation.api.ListPropertyValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.TAG;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#openapi-object">OpenAPI Object</a>
 * .tags(List of <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#tagObject">Tag Object</a>)校验器
 */
public class OpenApiTagsValidator extends ListPropertyValidator<OpenAPI, Tag>
  implements OpenApiValidator {

  public OpenApiTagsValidator(List<TagValidator> tagValidators) {
    super(tagValidators);
  }

  @Override
  protected String get$ref(OpenAPI oasObject) {
    return null;
  }

  @Override
  protected List<Tag> getListProperty(OpenAPI oasObject) {
    return oasObject.getTags();
  }

  @Override
  protected String getListPropertyName() {
    return "tags";
  }

  @Override
  protected OasObjectType getElementType() {
    return TAG;
  }

}
