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

@ContextConfiguration(classes = TagReferenceValidatorTest.TestConfiguration.class)
public class TagReferenceValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-tag-redundant.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).hasSize(1);
    assertThat(violations)
      .containsExactly(createViolation("此Tag没有被Operation Object使用过", "tags[1]", TAG));
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {
    @Bean

    public TagValidator tagReferenceValidator() {
      return new TagReferenceValidator();
    }
  }

}

