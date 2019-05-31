package com.supwisdom.institute.oasv.compatibility.validators.requestbody;

import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
import com.supwisdom.institute.oasv.diffvalidation.api.RequestBodyDiffValidator;
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

@ContextConfiguration(classes = RequestBodyRequiredChangeDiffValidatorTest.TestConfiguration.class)
public class RequestBodyRequiredChangeDiffValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
    OpenAPI leftOpenAPI = loadRelative("petstore-request-body-required-a.yaml");
    OpenAPI rightOpenAPI = loadRelative("petstore-request-body-required-b.yaml");
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolationBoth(
          "仅允许true->false的修改",
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "get", OPERATION,
            "requestBody", REQUEST_BODY,
            "required", null
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public RequestBodyDiffValidator requestBodyRequiredChangeDiffValidator() {

      return new RequestBodyRequiredChangeDiffValidator();
    }

  }

}

