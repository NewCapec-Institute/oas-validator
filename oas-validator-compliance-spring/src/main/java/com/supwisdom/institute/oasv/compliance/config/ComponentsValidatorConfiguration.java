package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.components.ComponentsKeysValidators;
import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComponentsValidatorConfiguration {

  @Bean
  public ComponentsValidator componentsCallbacksUpperCamelCaseValidator() {
    return ComponentsKeysValidators.CALLBACKS_UPPER_CAMEL_CASE_VALIDATOR;
  }

  @Bean
  public ComponentsValidator componentsExamplesUpperCamelCaseValidator() {
    return ComponentsKeysValidators.EXAMPLES_UPPER_CAMEL_CASE_VALIDATOR;
  }

  @Bean
  public ComponentsValidator componentsHeadersUpperHyphenCaseValidator() {
    return ComponentsKeysValidators.HEADERS_UPPER_HYPHEN_CASE_VALIDATOR;
  }

  @Bean
  public ComponentsValidator componentsLinksUpperCamelCaseValidator() {
    return ComponentsKeysValidators.LINKS_UPPER_CAMEL_CASE_VALIDATOR;
  }

  @Bean
  public ComponentsValidator componentsParametersUpperCamelCaseValidator() {
    return ComponentsKeysValidators.PARAMETERS_UPPER_CAMEL_CASE_VALIDATOR;
  }

  @Bean
  public ComponentsValidator componentsRequestBodiesUpperCamelCaseValidator() {
    return ComponentsKeysValidators.REQUEST_BODIES_UPPER_CAMEL_CASE_VALIDATOR;
  }

  @Bean
  public ComponentsValidator componentsResponsesUpperCamelCaseValidator() {
    return ComponentsKeysValidators.RESPONSES_UPPER_CAMEL_CASE_VALIDATOR;
  }

  @Bean
  public ComponentsValidator componentsSchemasUpperCamelCaseValidator() {
    return ComponentsKeysValidators.SCHEMAS_UPPER_CAMEL_CASE_VALIDATOR;
  }

}
