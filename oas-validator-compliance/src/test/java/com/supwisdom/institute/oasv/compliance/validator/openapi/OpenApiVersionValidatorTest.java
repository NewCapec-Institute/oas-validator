package com.supwisdom.institute.oasv.compliance.validator.openapi;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.OpenApiValidator;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = OpenApiVersionValidatorTest.TestConfiguration.class)
public class OpenApiVersionValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-openapi-wrong.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).hasSize(1);
    assertThat(violations).containsExactly(createViolation("必须>=3.0.2", "openapi", null));
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public OpenApiValidator openApiValidator() {

      return new OpenApiVersionValidator();
    }
  }

}

