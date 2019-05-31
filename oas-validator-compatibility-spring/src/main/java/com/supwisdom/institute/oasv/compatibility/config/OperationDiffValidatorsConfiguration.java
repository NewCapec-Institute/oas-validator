package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.diffvalidation.api.OperationDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.operation.OperationDeleteNotAllowedDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.operation.OperationIdNotSameDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.operation.OperationOAuth2ScopeNotSameDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationDiffValidatorsConfiguration {

  @Bean
  public OperationDiffValidator operationDeleteNotAllowedDiffValidator() {
    return new OperationDeleteNotAllowedDiffValidator();
  }

  @Bean
  public OperationDiffValidator operationIdNotSameDiffValidator() {
    return new OperationIdNotSameDiffValidator();
  }

  @Bean
  public OperationDiffValidator operationOAuth2ScopeNotSameDiffValidator() {
    return new OperationOAuth2ScopeNotSameDiffValidator();
  }

}
