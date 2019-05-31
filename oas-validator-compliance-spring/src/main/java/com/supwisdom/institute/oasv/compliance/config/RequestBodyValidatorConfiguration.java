package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.requestbody.RequestBodyDescriptionRequiredValidator;
import com.supwisdom.institute.oasv.validation.api.RequestBodyValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestBodyValidatorConfiguration {

  @Bean
  public RequestBodyValidator requestBodyDescriptionRequiredValidator() {
    return new RequestBodyDescriptionRequiredValidator();
  }

}
