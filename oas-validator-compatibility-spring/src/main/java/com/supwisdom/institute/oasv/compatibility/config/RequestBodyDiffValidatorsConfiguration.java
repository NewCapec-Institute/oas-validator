package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.diffvalidation.api.RequestBodyDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.requestbody.RequestBodyRequiredChangeDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RequestBodyDiffValidatorsConfiguration {

  @Bean
  public RequestBodyDiffValidator requestBodyRequiredChangeDiffValidator() {
    return new RequestBodyRequiredChangeDiffValidator();
  }

}
