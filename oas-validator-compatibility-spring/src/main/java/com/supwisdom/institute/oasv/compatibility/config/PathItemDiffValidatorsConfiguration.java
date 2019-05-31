package com.supwisdom.institute.oasv.compatibility.config;

import com.supwisdom.institute.oasv.diffvalidation.api.PathItemDiffValidator;
import com.supwisdom.institute.oasv.compatibility.validators.pathitem.PathItemDeleteNotAllowedDiffValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PathItemDiffValidatorsConfiguration {

  @Bean
  public PathItemDiffValidator pathItemDeleteNotAllowedValidator() {
    return new PathItemDeleteNotAllowedDiffValidator();
  }

}
