package com.supwisdom.institute.oasv.validation.skeleton.requestbody;

import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.MediaTypeValidator;
import com.supwisdom.institute.oasv.validation.api.RequestBodyValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.parameters.RequestBody;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.MEDIA_TYPE;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#request-body-object">Request Object</a>
 * .content属性校验器
 */
public class RequestBodyContentValidator
  extends MapPropertyValuesValidator<RequestBody, MediaType>
  implements RequestBodyValidator {

  public RequestBodyContentValidator(List<MediaTypeValidator> mediaTypeValidators) {
    super(mediaTypeValidators);
  }

  @Override
  protected String get$ref(RequestBody oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected Map<String, MediaType> getMapProperty(RequestBody oasObject) {
    return oasObject.getContent();
  }

  @Override
  protected String getMapPropertyName() {
    return "content";
  }

  @Override
  protected OasObjectType getValueType() {
    return MEDIA_TYPE;
  }

}
