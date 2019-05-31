package com.supwisdom.institute.oasv.validation.skeleton.response;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.HeaderValidator;
import com.supwisdom.institute.oasv.validation.api.ResponseValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import io.swagger.v3.oas.models.headers.Header;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.HEADER;

public class ResponseHeadersValuesValidator extends MapPropertyValuesValidator<ApiResponse, Header>
  implements ResponseValidator {

  public ResponseHeadersValuesValidator(List<HeaderValidator> valueValidators) {
    super(valueValidators);
  }

  @Override
  protected String get$ref(ApiResponse oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected Map<String, Header> getMapProperty(ApiResponse components) {
    return components.getHeaders();
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
