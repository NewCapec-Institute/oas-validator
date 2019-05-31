package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.compatibility.validators.encoding.*;
import com.supwisdom.institute.oasv.diffvalidation.api.EncodingDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncodingDiffValidatorsConfiguration {

  @Bean
  public EncodingDiffValidator encodingAddNotAllowedDiffValidator() {
    return new EncodingAddNotAllowedDiffValidator();
  }

  @Bean
  public EncodingDiffValidator encodingDelNotAllowedDiffValidator() {
    return new EncodingDelNotAllowedDiffValidator();
  }

  @Bean
  public EncodingDiffValidator encodingAllowedReservedChangeDiffValidator() {
    return new EncodingAllowedReservedChangeDiffValidator();
  }

  @Bean
  public EncodingDiffValidator encodingContentTypeNotSameDiffValidator() {
    return new EncodingContentTypeNotSameDiffValidator();
  }

  @Bean
  public EncodingDiffValidator encodingExplodeNotSameDiffValidator() {
    return new EncodingExplodeNotSameDiffValidator();
  }

  @Bean
  public EncodingDiffValidator encodingStyleNotSameDiffValidator() {
    return new EncodingStyleNotSameDiffValidator();
  }

}
