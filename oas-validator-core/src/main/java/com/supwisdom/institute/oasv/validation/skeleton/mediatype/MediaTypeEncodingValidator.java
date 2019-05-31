package com.supwisdom.institute.oasv.validation.skeleton.mediatype;

import com.supwisdom.institute.oasv.validation.api.EncodingValidator;
import com.supwisdom.institute.oasv.validation.api.MediaTypeValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import io.swagger.v3.oas.models.media.Encoding;
import io.swagger.v3.oas.models.media.MediaType;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.ENCODING;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#media-type-object">Media Type Object</a>
 * .encoding属性校验器
 */
public class MediaTypeEncodingValidator extends MapPropertyValuesValidator<MediaType, Encoding>
  implements MediaTypeValidator {

  public MediaTypeEncodingValidator(List<EncodingValidator> encodingValidators) {
    super(encodingValidators);
  }

  @Override
  protected String get$ref(MediaType oasObject) {
    return null;
  }

  @Override
  protected Map<String, Encoding> getMapProperty(MediaType oasObject) {
    return oasObject.getEncoding();
  }

  @Override
  protected String getMapPropertyName() {
    return "encoding";
  }

  @Override
  protected OasObjectType getValueType() {
    return ENCODING;
  }

}
