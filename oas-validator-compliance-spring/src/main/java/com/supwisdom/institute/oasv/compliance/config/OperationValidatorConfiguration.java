package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.operation.OperationIdLowerCamelCaseValidator;
import com.supwisdom.institute.oasv.compliance.validator.operation.OperationSummaryRequiredValidator;
import com.supwisdom.institute.oasv.compliance.validator.operation.OperationTagsOnlyOneValidator;
import com.supwisdom.institute.oasv.compliance.validator.operation.OperationTagsReferenceValidator;
import com.supwisdom.institute.oasv.validation.api.OperationValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperationValidatorConfiguration {

  @Bean
  public OperationValidator operationIdLowerCamelCaseValidator() {
    return new OperationIdLowerCamelCaseValidator();
  }

  @Bean
  public OperationValidator operationSummaryRequiredValidator() {
    return new OperationSummaryRequiredValidator();
  }

  @Bean
  public OperationValidator operationTagsOnlyOneValidator() {
    return new OperationTagsOnlyOneValidator();
  }

  @Bean
  public OperationValidator operationTagsReferenceValidator() {
    return new OperationTagsReferenceValidator();
  }

}
