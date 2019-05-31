package com.supwisdom.institute.oasv.compliance.config;

import com.supwisdom.institute.oasv.compliance.validator.tag.TagDescriptionRequiredValidator;
import com.supwisdom.institute.oasv.compliance.validator.tag.TagNameUpperCamelCaseValidator;
import com.supwisdom.institute.oasv.compliance.validator.tag.TagReferenceValidator;
import com.supwisdom.institute.oasv.validation.api.TagValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TagValidatorConfiguration {

  @Bean
  public TagValidator tagDescriptionRequiredValidator() {
    return new TagDescriptionRequiredValidator();
  }

  @Bean
  public TagValidator tagNameUpperCamelCaseValidator() {
    return new TagNameUpperCamelCaseValidator();
  }

  @Bean
  public TagValidator tagReferenceValidator() {
    return new TagReferenceValidator();
  }

}
