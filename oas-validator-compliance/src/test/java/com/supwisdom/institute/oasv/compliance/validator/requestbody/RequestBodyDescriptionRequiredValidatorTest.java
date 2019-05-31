package com.supwisdom.institute.oasv.compliance.validator.requestbody;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.RequestBodyValidator;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
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

@ContextConfiguration(classes = RequestBodyDescriptionRequiredValidatorTest.TestConfiguration.class)
public class RequestBodyDescriptionRequiredValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidate() {
    OpenAPI openAPI = loadRelative("petstore-request-body-desc-required.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.REQUIRED,
        "paths", PATHS,
        "/pets", PATH_ITEM,
        "post", OPERATION,
        "requestBody", REQUEST_BODY,
        "description", null
      ),
      createViolation(
        ViolationMessages.REQUIRED,
        "components", COMPONENTS,
        "requestBodies.'Foo'", REQUEST_BODY,
        "description", null
      )
    );
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public RequestBodyValidator requestBodyValidator() {

      return new RequestBodyDescriptionRequiredValidator();
    }

  }

}
