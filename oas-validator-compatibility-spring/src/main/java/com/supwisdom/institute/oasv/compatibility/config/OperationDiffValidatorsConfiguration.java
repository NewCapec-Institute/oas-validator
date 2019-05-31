package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.compatibility.validators.operation.OperationDeleteNotAllowedDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.operation.OperationIdNotSameDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OperationDiffValidator;
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

}
