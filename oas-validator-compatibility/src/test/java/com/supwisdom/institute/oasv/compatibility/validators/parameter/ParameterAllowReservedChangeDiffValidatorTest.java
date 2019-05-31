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

@ContextConfiguration(classes = ParameterAllowReservedChangeDiffValidatorTest.TestConfiguration.class)
public class ParameterAllowReservedChangeDiffValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
  }

  /**
   * TODO swagger parser对于allowReserved字段的反序列化存在问题，先跳过此测试
   * https://github.com/swagger-api/swagger-parser/issues/1108
   */
  public void validateBroken() {
    OpenAPI leftOpenAPI = loadRelative("petstore-parameter-allow-reserved-a.yaml");
    System.out.println(leftOpenAPI.toString());
    OpenAPI rightOpenAPI = loadRelative("petstore-parameter-allow-reserved-b.yaml");
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
            "allowReserved", null
          },
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "get", OPERATION,
            "parameters[2]", PARAMETER,
            "allowReserved", null
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public ParameterDiffValidator parameterAllowReservedChangeDiffValidator() {

      return new ParameterAllowReservedChangeDiffValidator();
    }

  }

}

