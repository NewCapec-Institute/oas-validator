package com.supwisdom.institute.oasv.compliance.validator.header;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import com.supwisdom.institute.oasv.validation.api.HeaderValidator;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
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

@ContextConfiguration(classes = HeaderDescriptionRequiredValidatorTest.TestConfiguration.class)
public class HeaderDescriptionRequiredValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-header-no-desc.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations)
      .containsExactlyInAnyOrder(
        createViolation("必须提供", "components", COMPONENTS, "headers.'X-Pet-Foo'", HEADER, "description", null),
        createViolation("必须提供",
          "paths", PATHS,
          "/pets", PATH_ITEM,
          "get", OPERATION,
          "responses", RESPONSES,
          "200", RESPONSE,
          "headers.'x-next'", HEADER,
          "description", null),
        createViolation("必须提供",
          "paths", PATHS,
          "/pets", PATH_ITEM,
          "get", OPERATION,
          "responses", RESPONSES,
          "201", RESPONSE,
          "content.'application/*'", MEDIA_TYPE,
          "encoding.'abc'", ENCODING,
          "headers.'X-Pet-Foo'", HEADER,
          "description", null)
      );
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public HeaderValidator headerValidator() {
      return new HeaderDescriptionRequiredValidator();
    }

  }

}
