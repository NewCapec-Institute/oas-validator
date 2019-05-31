package com.supwisdom.institute.oasv.validation.skeleton.encoding;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.EncodingValidator;
import com.supwisdom.institute.oasv.validation.api.HeaderValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.media.Encoding;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.HEADER;

public class EncodingHeadersValuesValidator extends MapPropertyValuesValidator<Encoding, Header>
  implements EncodingValidator {

  public EncodingHeadersValuesValidator(List<HeaderValidator> valueValidators) {
    super(valueValidators);
  }

  @Override
  protected String get$ref(Encoding oasObject) {
    return null;
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
