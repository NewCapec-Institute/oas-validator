package com.supwisdom.institute.oasv.compatibility.validators.mediatype;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.MediaTypeDiffValidator;
import com.supwisdom.institute.oasv.diffvalidation.api.OasDiffViolation;
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

@ContextConfiguration(classes = MediaTypeDelInRequestBodyNotAllowedDiffValidatorTest.TestConfiguration.class)
public class MediaTypeDelInRequestBodyNotAllowedDiffValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
    OpenAPI leftOpenAPI = loadRelative("petstore-media-type-del-in-request-body-a.yaml");
    OpenAPI rightOpenAPI = loadRelative("petstore-media-type-del-in-request-body-b.yaml");
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolationLeft(
          DiffViolationMessages.OP_DEL_FORBIDDEN,
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "get", OPERATION,
            "requestBody", REQUEST_BODY,
            "content.'application/json'", MEDIA_TYPE
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public MediaTypeDiffValidator mediaTypeDelInRequestBodyNotAllowedDiffValidator() {

      return new MediaTypeDelInRequestBodyNotAllowedDiffValidator();
    }

  }

}

