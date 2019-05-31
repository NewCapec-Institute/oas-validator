package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.diffvalidation.api.ResponseDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.response.ResponseAddNotAllowedDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ResponseDiffValidatorsConfiguration {

  @Bean
  public ResponseDiffValidator responseAddNotAllowedDiffValidator() {
    return new ResponseAddNotAllowedDiffValidator();
  }

}
