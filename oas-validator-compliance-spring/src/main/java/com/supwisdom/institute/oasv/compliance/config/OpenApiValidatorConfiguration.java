package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.openapi.OpenApiTagNotEmptyValidator;
import com.supwisdom.institute.oasv.compliance.validator.openapi.OpenApiVersionValidator;
import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiValidatorConfiguration {

  @Bean
  public OpenApiValidator openApiTagNotEmptyValidator() {
    return new OpenApiTagNotEmptyValidator();
  }

  @Bean
  public OpenApiValidator openApiVersionValidator() {
    return new OpenApiVersionValidator();
  }

}
