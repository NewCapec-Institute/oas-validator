package com.supwisdom.institute.oasv.compliance.validator.operation;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.OperationValidator;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.*;
import static com.supwisdom.institute.oasv.validation.api.ViolationMessages.MUST_BE_EMPTY;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = OperationServersEmptyValidatorTest.TestConfiguration.class)
public class OperationServersEmptyValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-operation-servers-empty.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactly(
      createViolation(MUST_BE_EMPTY,
        "paths", PATHS,
        "/pets", PATH_ITEM,
        "get", OPERATION,
        "servers", SERVER));
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public OperationValidator operationValidator() {
      return new OperationServersEmptyValidator();
    }

  }

}


