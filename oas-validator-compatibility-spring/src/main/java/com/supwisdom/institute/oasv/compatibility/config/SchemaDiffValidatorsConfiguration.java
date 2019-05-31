package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.compatibility.validators.schema.request.*;
import com.supwisdom.institute.oasv.compatibility.validators.schema.response.*;
import com.supwisdom.institute.oasv.diffvalidation.api.SchemaCompareValidator;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaDiscriminatorChangeValidator;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaReadOnlyChangeValidator;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaWriteOnlyChangeValidator;
import com.supwisdom.institute.oasv.compatibility.validators.schema.SchemaXmlChangeValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SchemaDiffValidatorsConfiguration {

  @Bean
  public SchemaCompareValidator schemaTypeFormatInRequestCompareValidator() {
    return new SchemaTypeFormatChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaTypeFormatInResponseCompareValidator() {
    return new SchemaTypeFormatChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMultipleOfChangeInRequestValidator() {
    return new SchemaMultipleOfChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaximumChangeInResponseValidator() {
    return new SchemaMaximumChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaximumChangeInRequestValidator() {
    return new SchemaMaximumChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaExclusiveMinimumChangeInRequestValidator() {
    return new SchemaExclusiveMinimumChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaExclusiveMaximumChangeInRequestValidator() {
    return new SchemaExclusiveMaximumChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaExclusiveMaximumChangeInResponseValidator() {
    return new SchemaExclusiveMaximumChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaExclusiveMinimumChangeInResponseValidator() {
    return new SchemaExclusiveMinimumChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaxItemsChangeInRequestValidator() {
    return new SchemaMaxItemsChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaxLengthChangeInRequestValidator() {
    return new SchemaMaxLengthChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaxPropertiesChangeInRequestValidator() {
    return new SchemaMaxPropertiesChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinimumChangeInRequestValidator() {
    return new SchemaMinimumChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinItemsChangeInRequestValidator() {
    return new SchemaMinItemsChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinLengthChangeInRequestValidator() {
    return new SchemaMinLengthChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinPropertiesChangeInRequestValidator() {
    return new SchemaMinPropertiesChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaUniqueItemsChangeInRequestValidator() {
    return new SchemaUniqueItemsChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaRequiredChangeInRequestValidator() {
    return new SchemaRequiredChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaEnumChangeInRequestValidator() {
    return new SchemaEnumChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaNullableChangeInRequestValidator() {
    return new SchemaNullableChangeInRequestValidator();
  }

  @Bean
  public SchemaCompareValidator schemaReadOnlyChangeValidator() {
    return new SchemaReadOnlyChangeValidator();
  }

  @Bean
  public SchemaCompareValidator schemaWriteOnlyChangeValidator() {
    return new SchemaWriteOnlyChangeValidator();
  }

  @Bean
  public SchemaCompareValidator schemaXmlChangeValidator() {
    return new SchemaXmlChangeValidator();
  }

  @Bean
  public SchemaCompareValidator schemaDiscriminatorChangeValidator() {
    return new SchemaDiscriminatorChangeValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMultipleOfChangeInResponseValidator() {
    return new SchemaMultipleOfChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaxItemsChangeInResponseValidator() {
    return new SchemaMaxItemsChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaxLengthChangeInResponseValidator() {
    return new SchemaMaxLengthChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMaxPropertiesChangeInResponseValidator() {
    return new SchemaMaxPropertiesChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinimumChangeInResponseValidator() {
    return new SchemaMinimumChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinItemsChangeInResponseValidator() {
    return new SchemaMinItemsChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinLengthChangeInResponseValidator() {
    return new SchemaMinLengthChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaMinPropertiesChangeInResponseValidator() {
    return new SchemaMinPropertiesChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaUniqueItemsChangeInResponseValidator() {
    return new SchemaUniqueItemsChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaRequiredChangeInResponseValidator() {
    return new SchemaRequiredChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaEnumChangeInResponseValidator() {
    return new SchemaEnumChangeInResponseValidator();
  }

  @Bean
  public SchemaCompareValidator schemaNullableChangeInResponseValidator() {
    return new SchemaNullableChangeInResponseValidator();
  }
}
