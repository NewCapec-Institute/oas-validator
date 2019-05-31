package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.header.HeaderDescriptionRequiredValidator;
import com.supwisdom.institute.oasv.validation.api.HeaderValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderValidatorConfiguration {

  @Bean
  public HeaderValidator headerDescriptionRequiredValidator() {
    return new HeaderDescriptionRequiredValidator();
  }

}
