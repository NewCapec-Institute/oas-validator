package com.supwisdom.institute.oasv.compliance.validator.parameter;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.ParameterValidator;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.*;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = ParameterPathLowerCamelCaseValidatorTest.TestConfiguration.class)
public class ParameterPathLowerCamelCaseValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-parameter-path-lower-camel-case.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "paths", PATHS,
        "/pets/{PetId}", PATH_ITEM,
        "get", OPERATION,
        "parameters[0]", PARAMETER,
        "name", null
      ),
      createViolation(
        ViolationMessages.LOWER_CAMEL_CASE,
        "components", COMPONENTS,
        "parameters.'Bar'", PARAMETER,
        "name", null
      )
    );
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public ParameterValidator parameterValidator() {
      return new ParameterPathLowerCamelCaseValidator();
    }

  }

}

