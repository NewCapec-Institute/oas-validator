package com.supwisdom.institute.oasv.validation.skeleton.response;

import com.supwisdom.institute.oasv.validation.api.ResponseValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyKeysValidator;
import io.swagger.v3.oas.models.responses.ApiResponse;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#componentsObject">ApiResponse Object</a>
 * .callbacks属性key校验器
 */
public class ResponseHeadersKeysValidator extends MapPropertyKeysValidator<ApiResponse>
  implements ResponseValidator {

  public ResponseHeadersKeysValidator(Predicate<String> keyPredicate,
    Function<String, String> errorFunction) {
    super(keyPredicate, errorFunction);
  }

  @Override
  protected String get$ref(ApiResponse oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected Map<String, ?> getMapProperty(ApiResponse oasObject) {
    return oasObject.getHeaders();
  }

  @Override
  protected String getMapPropertyName() {
    return "headers";
  }

}
