package com.supwisdom.institute.oasv.compatibility.validators.parameter;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.ParameterDiffValidator;
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

@ContextConfiguration(classes = ParameterAllowEmptyValueChangeDiffValidatorTest.TestConfiguration.class)
public class ParameterAllowEmptyValueChangeDiffValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
    OpenAPI leftOpenAPI = loadRelative("petstore-parameter-allow-empty-value-a.yaml");
    OpenAPI rightOpenAPI = loadRelative("petstore-parameter-allow-empty-value-b.yaml");
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolation(
          "[name=limit4,in=query]:仅允许false->true的修改",
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "get", OPERATION,
            "parameters[1]", PARAMETER,
            "allowEmptyValue", null
          },
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "get", OPERATION,
            "parameters[2]", PARAMETER,
            "allowEmptyValue", null
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public ParameterDiffValidator parameterAllowEmptyValueChangeDiffValidator() {

      return new ParameterAllowEmptyValueChangeDiffValidator();
    }

  }

}

