package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.compatibility.validators.parameter.*;
import com.supwisdom.institute.oasv.diffvalidation.api.ParameterDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParameterDiffValidatorsConfiguration {

  @Bean
  public ParameterDiffValidator parameterAddDiffValidator() {
    return new ParameterAddDiffValidator();
  }

  @Bean
  public ParameterDiffValidator parameterRequiredChangeDiffValidator() {
    return new ParameterRequiredChangeDiffValidator();
  }

  @Bean
  public ParameterDiffValidator parameterAllowEmptyValueChangeDiffValidator() {
    return new ParameterAllowEmptyValueChangeDiffValidator();
  }

  @Bean
  public ParameterDiffValidator parameterStyleNotSameDiffValidator() {
    return new ParameterStyleNotSameDiffValidator();
  }

  @Bean
  public ParameterDiffValidator parameterExplodeNotSameDiffValidator() {
    return new ParameterExplodeNotSameDiffValidator();
  }

  @Bean
  public ParameterDiffValidator parameterAllowReservedChangeDiffValidator() {
    return new ParameterAllowReservedChangeDiffValidator();
  }

}

