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

@ContextConfiguration(classes = ParameterHeaderUpperHyphenCaseValidatorTest.TestConfiguration.class)
public class ParameterHeaderUpperHyphenCaseValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-parameter-header-upper-hyphen-case.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.UPPER_HYPHEN_CASE,
        "paths", PATHS,
        "/pets/{petId}", PATH_ITEM,
        "get", OPERATION,
        "parameters[1]", PARAMETER,
        "name", null
      ),
      createViolation(
        ViolationMessages.UPPER_HYPHEN_CASE,
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
      return new ParameterHeaderUpperHyphenCaseValidator();
    }

  }

}

