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

import static com.supwisdom.institute.oasv.common.OasObjectType.SECURITY_REQUIREMENT;
import static com.supwisdom.institute.oasv.validation.api.ViolationMessages.MUST_BE_EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = OpenApiSecurityEmptyValidatorTest.TestConfiguration.class)
public class OpenApiSecurityEmptyValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-security-empty.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactly(createViolation(MUST_BE_EMPTY, "security", SECURITY_REQUIREMENT));
  }

  @Test
  public void testValidateGood() {
    OpenAPI openAPI = loadRelative("petstore-security-empty-good.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).isEmpty();
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {
    @Bean

    public OpenApiValidator openApiValidator() {

      return new OpenApiSecurityEmptyValidator();
    }
  }

}
