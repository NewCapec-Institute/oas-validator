package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.schema.SchemaKeysValidators;
import com.supwisdom.institute.oasv.compliance.validator.schema.SchemaTitleValidator;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchemaValidatorConfiguration {

  @Bean
  public SchemaValidator schemaTitleValidator() {
    return new SchemaTitleValidator();
  }

  @Bean
  public SchemaValidator schemaPropertiesLowerCamelCaseValidator() {
    return SchemaKeysValidators.PROPERTIES_LOWER_CAMEL_CASE_VALIDATOR;
  }
}
