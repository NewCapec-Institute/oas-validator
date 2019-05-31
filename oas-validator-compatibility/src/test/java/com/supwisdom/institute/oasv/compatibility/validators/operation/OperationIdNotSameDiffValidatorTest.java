package com.supwisdom.institute.oasv.compatibility.validators.operation;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.OperationDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.config.OasDiffValidatorsSkeletonConfiguration;

import com.supwisdom.institute.oasv.compatibility.validators.OasCompatibilityTestBase;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.*;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = OperationIdNotSameDiffValidatorTest.TestConfiguration.class)
public class OperationIdNotSameDiffValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
    OpenAPI leftOpenAPI = loadRelative("petstore-operation-id-a.yaml");
    OpenAPI rightOpenAPI = loadRelative("petstore-operation-id-b.yaml");
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolationBoth(
          DiffViolationMessages.NEW_NOT_EQ_OLD,
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "post", OPERATION,
            "operationId", null
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public OperationDiffValidator operationIdNotSameDiffValidator() {

      return new OperationIdNotSameDiffValidator();
    }

  }

}

