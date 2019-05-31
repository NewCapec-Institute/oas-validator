package com.supwisdom.institute.oasv.validation.skeleton.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.LinkValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.links.Link;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.LINK;

public class ComponentsLinksValuesValidator extends MapPropertyValuesValidator<Components, Link>
  implements ComponentsValidator {

  public ComponentsLinksValuesValidator(List<LinkValidator> valueValidators) {
    super(valueValidators);
  }

  @Override
  protected String get$ref(Components oasObject) {
    return null;
  }

  @Override
  protected Map<String, Link> getMapProperty(Components components) {
    return components.getLinks();
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
