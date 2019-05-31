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
import static com.supwisdom.institute.oasv.compliance.validator.components.ComponentsKeysValidators.SCHEMAS_UPPER_CAMEL_CASE_VALIDATOR;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = ComponentsSchemasUpperCamelCaseValidatorTest.TestConfiguration.class)
public class ComponentsSchemasUpperCamelCaseValidatorTest extends OasComplianceTestBase {

  @Test
  public void testUpperCamelCase() {
    OpenAPI openAPI = loadRelative("petstore-schemas-upper-camel-case.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolation(ViolationMessages.UPPER_CAMEL_CASE,
          "components", COMPONENTS,
          "schemas.'foo'", null)
      );
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public ComponentsValidator componentsValidator() {


      return SCHEMAS_UPPER_CAMEL_CASE_VALIDATOR;
    }

  }

}

