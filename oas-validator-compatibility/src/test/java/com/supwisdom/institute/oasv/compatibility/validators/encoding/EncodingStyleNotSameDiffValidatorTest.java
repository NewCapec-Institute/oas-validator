package com.supwisdom.institute.oasv.compatibility.validators.encoding;

import com.supwisdom.institute.oasv.diffvalidation.api.DiffViolationMessages;
import com.supwisdom.institute.oasv.diffvalidation.api.EncodingDiffValidator;
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

@ContextConfiguration(classes = EncodingStyleNotSameDiffValidatorTest.TestConfiguration.class)
public class EncodingStyleNotSameDiffValidatorTest extends OasCompatibilityTestBase {

  @Test
  public void validate() {
    OpenAPI leftOpenAPI = loadRelative("petstore-encoding-style-a.yaml");
    OpenAPI rightOpenAPI = loadRelative("petstore-encoding-style-b.yaml");
    List<OasDiffViolation> violations = oasSpecDiffValidator
      .validate(createContext(leftOpenAPI, rightOpenAPI), leftOpenAPI, rightOpenAPI);

    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolation(
          DiffViolationMessages.NEW_NOT_EQ_OLD,
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "post", OPERATION,
            "requestBody", REQUEST_BODY,
            "content.'application/x-www-form-urlencoded'", MEDIA_TYPE,
            "encoding.'foo'", ENCODING,
            "style", null
          },
          new Object[] {
            "paths", PATHS,
            "/pets", PATH_ITEM,
            "post", OPERATION,
            "requestBody", REQUEST_BODY,
            "content.'application/x-www-form-urlencoded'", MEDIA_TYPE,
            "encoding.'foo'", ENCODING,
            "style", null
          }
        )
      );

  }

  @Configuration
  @Import(OasDiffValidatorsSkeletonConfiguration.class)
  public static class TestConfiguration {

    @Bean
    public EncodingDiffValidator encodingStyleNotSameDiffValidator() {

      return new EncodingStyleNotSameDiffValidator();
    }

  }

}

