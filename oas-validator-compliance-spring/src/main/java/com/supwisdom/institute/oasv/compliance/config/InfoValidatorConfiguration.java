package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.info.InfoDescriptionRequiredValidator;
import com.supwisdom.institute.oasv.validation.api.InfoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InfoValidatorConfiguration {

  @Bean
  public InfoValidator infoDescriptionRequiredValidator() {
    return new InfoDescriptionRequiredValidator();
  }

}
