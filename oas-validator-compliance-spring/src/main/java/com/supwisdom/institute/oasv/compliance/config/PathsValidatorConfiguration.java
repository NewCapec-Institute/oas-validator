package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.paths.PathsLowerCamelCaseValidator;
import com.supwisdom.institute.oasv.validation.api.PathsValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PathsValidatorConfiguration {

  @Bean
  public PathsValidator pathsLowerCamelCaseValidator() {
    return new PathsLowerCamelCaseValidator();
  }

}
