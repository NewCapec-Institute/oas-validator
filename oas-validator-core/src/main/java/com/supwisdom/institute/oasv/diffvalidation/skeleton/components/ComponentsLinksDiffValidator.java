package com.supwisdom.institute.oasv.diffvalidation.skeleton.components;

import com.supwisdom.institute.oasv.diffvalidation.api.ComponentsDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.LinkDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.links.Link;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.LINK;

public class ComponentsLinksDiffValidator
  extends MapPropertyDiffValidator<Components, Link>
  implements ComponentsDiffValidator {

  public ComponentsLinksDiffValidator(List<LinkDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, Link> getMapProperty(Components oasObject) {
    return oasObject.getLinks();
  }

  @Override
  protected String getMapPropertyName() {
    return "links";
  }

  @Override
  protected OasObjectType getValueType() {
    return LINK;
  }
}
