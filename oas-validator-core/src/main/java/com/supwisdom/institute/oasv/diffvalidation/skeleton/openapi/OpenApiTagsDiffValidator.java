package com.supwisdom.institute.oasv.diffvalidation.skeleton.openapi;

import com.supwisdom.institute.oasv.diffvalidation.api.ListPropertyDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OpenApiDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.TagDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.tags.Tag;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.TAG;

public class OpenApiTagsDiffValidator
  extends ListPropertyDiffValidator<OpenAPI, Tag>
  implements OpenApiDiffValidator {

  public OpenApiTagsDiffValidator(List<TagDiffValidator> diffValidators) {
    super(diffValidators, tag -> tag.getName());
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
