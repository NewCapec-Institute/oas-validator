package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.encoding.EncodingKeysValidators;
import com.supwisdom.institute.oasv.validation.api.EncodingValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncodingValidatorConfiguration {

  @Bean
  public EncodingValidator encodingHeadersUpperHyphenCaseValidator() {
    return EncodingKeysValidators.HEADERS_UPPER_HYPHEN_CASE_VALIDATOR;
  }

}
