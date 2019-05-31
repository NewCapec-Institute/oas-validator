package com.supwisdom.institute.oasv.compliance.validator.schema;

import com.supwisdom.institute.oasv.compliance.validator.OasComplianceTestBase;
import com.supwisdom.institute.oasv.validation.api.OasViolation;
import com.supwisdom.institute.oasv.validation.api.SchemaValidator;
import com.supwisdom.institute.oasv.validation.api.ViolationMessages;
import com.supwisdom.institute.oasv.validation.config.OasValidatorsSkeletonConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static com.supwisdom.institute.oasv.common.OasObjectType.COMPONENTS;
import static com.supwisdom.institute.oasv.common.OasObjectType.SCHEMA;
import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration(classes = SchemaTitleValidatorTest.TestConfiguration.class)
public class SchemaTitleValidatorTest extends OasComplianceTestBase {

  @Test
  public void testValidateComponents() {
    OpenAPI openAPI = loadRelative("petstore-schema-title-comp.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.REQUIRED,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "title", null
      )
    );
  }

  @Test
  public void testValidateNested() {
    OpenAPI openAPI = loadRelative("petstore-schema-title-nested.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).containsExactlyInAnyOrder(
      createViolation(
        ViolationMessages.REQUIRED,
        "components", COMPONENTS,
        "schemas.'Foo'", SCHEMA,
        "properties.'Foo'", SCHEMA,
        "title", null
      )
    );
  }

  @Test
  public void testValidateParameter() {
    OpenAPI openAPI = loadRelative("petstore-schema-title-param.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).isEmpty();
  }

  @Test
  public void testValidateRequestBody() {
    OpenAPI openAPI = loadRelative("petstore-schema-title-req.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).isEmpty();
  }

  @Test
  public void testValidateResponse() {
    OpenAPI openAPI = loadRelative("petstore-schema-title-resp.yaml");
    List<OasViolation> violations = oasSpecValidator.validate(createContext(openAPI), openAPI);
    assertThat(violations).isEmpty();
  }

  @Configuration
  @Import({
    OasValidatorsSkeletonConfiguration.class
  })
  public static class TestConfiguration {

    @Bean

    public SchemaValidator schemaValidator() {
      return new SchemaTitleValidator();
    }
  }

}
