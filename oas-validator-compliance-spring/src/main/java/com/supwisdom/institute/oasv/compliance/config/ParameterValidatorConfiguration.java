package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.parameter.*;
import com.supwisdom.institute.oasv.validation.api.ParameterValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ParameterValidatorConfiguration {

  @Bean
  public ParameterValidator parameterCookieLowerCamelCaseValidator() {
    return new ParameterCookieLowerCamelCaseValidator();
  }

  @Bean
  public ParameterValidator parameterHeaderUpperHyphenCaseValidator() {
    return new ParameterHeaderUpperHyphenCaseValidator();
  }

  @Bean
  public ParameterValidator parameterPathLowerCamelCaseValidator() {
    return new ParameterPathLowerCamelCaseValidator();
  }

  @Bean
  public ParameterValidator parameterQueryLowerCamelCaseValidator() {
    return new ParameterQueryLowerCamelCaseValidator();
  }

  @Bean
  public ParameterValidator parameterDescriptionRequiredValidator() {
    return new ParameterDescriptionRequiredValidator();
  }

}
