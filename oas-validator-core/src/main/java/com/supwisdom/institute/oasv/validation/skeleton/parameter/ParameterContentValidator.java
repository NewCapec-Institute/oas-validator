package com.supwisdom.institute.oasv.validation.skeleton.parameter;

import com.supwisdom.institute.oasv.validation.api.MediaTypeValidator;
import com.supwisdom.institute.oasv.common.OasObjectType;
import com.supwisdom.institute.oasv.validation.api.ParameterValidator;
import com.supwisdom.institute.oasv.validation.api.MapPropertyValuesValidator;
import io.swagger.v3.oas.models.media.MediaType;
import io.swagger.v3.oas.models.parameters.Parameter;

import java.util.List;
import java.util.Map;

import static com.supwisdom.institute.oasv.common.OasObjectType.MEDIA_TYPE;

/**
 * <a href="https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#parameterObject">Parameter Object</a>属性校验器
 * .content属性校验器
 */
public class ParameterContentValidator extends MapPropertyValuesValidator<Parameter, MediaType>
  implements ParameterValidator {

  public ParameterContentValidator(List<MediaTypeValidator> mediaTypeValidators) {
    super(mediaTypeValidators);
  }

  @Override
  protected String get$ref(Parameter oasObject) {
    return oasObject.get$ref();
  }

  @Override
  protected Map<String, MediaType> getMapProperty(Parameter oasObject) {
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
