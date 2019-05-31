package com.supwisdom.institute.oasv.compliance.validator.components;

import com.supwisdom.institute.oasv.validation.api.ComponentsValidator;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;


import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.COMPONENTS;
import static com.supwisdom.institute.oasv.compliance.validator.components.ComponentsKeysValidators.HEADERS_UPPER_HYPHEN_CASE_VALIDATOR;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = ComponentsHeadersUpperCamelCaseValidatorTest.TestConfiguration.class)
public class ComponentsHeadersUpperCamelCaseValidatorTest extends OasComplianceTestBase {

  @Test
  public void testUpperCamelCase() {
    OpenAPI openAPI = loadRelative("petstore-headers-upper-camel-case.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolation(ViolationMessages.UPPER_HYPHEN_CASE,
          "components", COMPONENTS,
          "headers.'foo'", null)
      );
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public ComponentsValidator componentsValidator() {


      return HEADERS_UPPER_HYPHEN_CASE_VALIDATOR;
    }

  }

}

