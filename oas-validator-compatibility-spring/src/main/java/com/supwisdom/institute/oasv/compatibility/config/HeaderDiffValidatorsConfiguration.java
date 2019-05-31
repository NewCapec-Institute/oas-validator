package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.diffvalidation.api.HeaderDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.header.HeaderAddInRequestBodyNotAllowedDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.header.HeaderDelInResponseNotAllowedDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderDiffValidatorsConfiguration {

  @Bean
  public HeaderDiffValidator headerAddInRequestBodyNotAllowedDiffValidator() {
    return new HeaderAddInRequestBodyNotAllowedDiffValidator();
  }

  @Bean
  public HeaderDiffValidator headerDelInResponseNotAllowedDiffValidator() {
    return new HeaderDelInResponseNotAllowedDiffValidator();
  }

}
