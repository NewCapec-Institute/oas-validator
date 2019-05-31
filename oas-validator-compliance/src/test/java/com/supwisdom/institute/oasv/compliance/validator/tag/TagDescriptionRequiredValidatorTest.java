package com.supwisdom.institute.oasv.compliance.validator.tag;

import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.TagValidator;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.TAG;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = TagDescriptionRequiredValidatorTest.TestConfiguration.class)
public class TagDescriptionRequiredValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-tag-no-desc.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).hasSize(1);
    assertThat(violations)
      .containsExactly(createViolation("必须提供", "tags[0]", TAG, "description", null));
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {
    @Bean

    public TagValidator tagDescriptionRequiredValidator() {
      return new TagDescriptionRequiredValidator();
    }
  }

}
