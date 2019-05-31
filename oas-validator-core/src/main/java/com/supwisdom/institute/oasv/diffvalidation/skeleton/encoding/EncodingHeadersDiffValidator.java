package com.supwisdom.institute.oasv.diffvalidation.skeleton.encoding;

import com.supwisdom.institute.oasv.diffvalidation.api.EncodingDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.HeaderDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.MapPropertyDiffValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.media.Encoding;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.HEADER;

public class EncodingHeadersDiffValidator
  extends MapPropertyDiffValidator<Encoding, Header>
  implements EncodingDiffValidator {

  public EncodingHeadersDiffValidator(List<HeaderDiffValidator> diffValidators) {
    super(diffValidators);
  }

  @Override
  protected Map<String, Header> getMapProperty(Encoding oasObject) {
    return oasObject.getHeaders();
  }

  @Override
  protected String getMapPropertyName() {
    return "headers";
  }

  @Override
  protected OasObjectType getValueType() {
    return HEADER;
  }
}
