package com.supwisdom.institute.oasv.validation.skeleton.encoding;

import com.supwisdom.institute.oasv.validation.api.MapPropertyKeysValidator;
import com.supwisdom.institute.oasv.validation.api.EncodingValidator;
import io.swagger.v3.oas.models.media.Encoding;

import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#encodingObject">Encoding Object</a>
 * .headers属性校验器
 */
public class EncodingHeadersKeysValidator extends MapPropertyKeysValidator<Encoding>
  implements EncodingValidator {

  public EncodingHeadersKeysValidator(Predicate<String> keyPredicate,
    Function<String, String> errorFunction) {
    super(keyPredicate, errorFunction);
  }

  @Override
  protected String get$ref(Encoding oasObject) {
    return null;
  }

  @Override
  protected Map<String, ?> getMapProperty(Encoding oasObject) {
    return oasObject.getHeaders();
  }

  @Override
  protected String getMapPropertyName() {
    return "headers";
  }

}
