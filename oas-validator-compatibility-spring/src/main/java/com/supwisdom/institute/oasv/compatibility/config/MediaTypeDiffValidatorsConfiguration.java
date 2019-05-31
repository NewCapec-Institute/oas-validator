package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.diffvalidation.api.MediaTypeDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.mediatype.MediaTypeAddInParameterNotAllowedDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.mediatype.MediaTypeDelInParameterNotAllowedDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.mediatype.MediaTypeDelInRequestBodyNotAllowedDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.mediatype.MediaTypeDelInResponseNotAllowedDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MediaTypeDiffValidatorsConfiguration {

  @Bean
  public MediaTypeDiffValidator mediaTypeAddInParameterNotAllowedDiffValidator() {
    return new MediaTypeAddInParameterNotAllowedDiffValidator();
  }

  @Bean
  public MediaTypeDiffValidator mediaTypeDelInParameterNotAllowedDiffValidator() {
    return new MediaTypeDelInParameterNotAllowedDiffValidator();
  }

  @Bean
  public MediaTypeDiffValidator mediaTypeDelInRequestBodyNotAllowedDiffValidator() {
    return new MediaTypeDelInRequestBodyNotAllowedDiffValidator();
  }

  @Bean
  public MediaTypeDiffValidator mediaTypeDelInResponseNotAllowedDiffValidator() {
    return new MediaTypeDelInResponseNotAllowedDiffValidator();
  }

}
