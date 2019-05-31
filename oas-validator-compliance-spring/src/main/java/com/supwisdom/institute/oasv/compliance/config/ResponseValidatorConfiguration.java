package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.response.ResponseKeysValidators;
import com.supwisdom.institute.oasv.validation.api.ResponseValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseValidatorConfiguration {

  @Bean
  public ResponseValidator responseHeadersUpperHyphenCaseValidator() {
    return ResponseKeysValidators.HEADERS_UPPER_HYPHEN_CASE_VALIDATOR;
  }

}
